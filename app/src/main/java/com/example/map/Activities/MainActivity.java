package com.example.map.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.map.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  {

    private TextView latTV;
    private TextView lngTV;
    private TextView firebaselatTV,firebaseText,currentText;
    private TextView firebaselngTV;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;

    private  ImageView imageView;

    FusedLocationProviderClient fusedLocationProviderClient;
    private Location location;
    private Button button,anim,next;
    String currentPhotoPath;


    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);





        latTV = findViewById(R.id.latTV);
        lngTV = findViewById(R.id.lngTV);
        firebaselatTV = findViewById(R.id.firebaselatTV);
        firebaselngTV = findViewById(R.id.firebaselngTV);
        button = findViewById(R.id.button);
        anim = findViewById(R.id.Animation);
        next = findViewById(R.id.next);
        imageView = findViewById(R.id.captureImageView);
        firebaseText = findViewById(R.id.firebaseText);
        currentText = findViewById(R.id.currentText);

        getLocation();
        checkLocationUpdates();
    }







    LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);

            for (Location location : locationResult.getLocations()) {


                latTV.setText("Latitude: "+location.getLatitude());
                lngTV.setText("Longitude: "+location.getLongitude());



                double lat =  location.getLatitude();
                double lng =  location.getLongitude();


                Map<String, Object> myLocations =  new HashMap<>();
                myLocations.put("lat",lat);
                myLocations.put("lng",lng);

                db.collection("MyLocations").document("Current Locations").set(myLocations)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {





                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });

                db.collection("MyLocations").document("Current Locations").get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {


                                firebaselatTV.setText(String.valueOf(documentSnapshot.getDouble("lat")));
                                firebaselngTV.setText(String.valueOf(documentSnapshot.getDouble("lng")));

                            }
                        });
            }
        }

        @Override
        public void onLocationAvailability(LocationAvailability locationAvailability) {
            super.onLocationAvailability(locationAvailability);
        }
    };

    private void checkLocationUpdates() {

        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(2000);
        locationRequest.setFastestInterval(4000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);


        SettingsClient client = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }else{
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
        }



    }

    private void getLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);

        }else{
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {

                    double lat = location.getLatitude();
                    double lng = location.getLongitude();
                    Toast.makeText(MainActivity.this, ""+lat, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, ""+lng, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


    public void onClick(View view) {

        dispatchTakePictureIntent();

    }



    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.map",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            setPic();
        }
    }



    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        Toast.makeText(this, ""+currentPhotoPath, Toast.LENGTH_SHORT).show();
        return image;
    }



    private void setPic() {
        // Get the dimensions of the View
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;

        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath, bmOptions);
        imageView.setImageBitmap(bitmap);
    }

    public void startAnimation(View view) {

        //Alpha or Fade Effect
        ObjectAnimator objectAnimator =  ObjectAnimator.ofFloat(firebaseText,View.ALPHA,1,0);
        objectAnimator.setDuration(4000);
        objectAnimator.setRepeatCount(2);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();


        //Translate Effect
        ObjectAnimator objectAnimator1 =  ObjectAnimator.ofFloat(firebaselngTV,View.TRANSLATION_Y,0,300);
        objectAnimator1.setDuration(4000);
        objectAnimator1.setRepeatCount(2);
        objectAnimator1.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator1.start();

        //Translate Effect
        ObjectAnimator objectAnimator2 =  ObjectAnimator.ofFloat(firebaselatTV,View.TRANSLATION_X,0,300);
        objectAnimator2.setDuration(4000);
        objectAnimator2.setRepeatCount(5);
        objectAnimator2.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator2.start();


        //Rotation Effect
        ObjectAnimator objectAnimator3 =  ObjectAnimator.ofFloat(latTV,View.ROTATION_Y,0,300);
        objectAnimator3.setDuration(4000);
        objectAnimator3.setRepeatCount(5);
        objectAnimator3.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator3.start();

        //Rotation Effect
        ObjectAnimator objectAnimator4 =  ObjectAnimator.ofFloat(lngTV,View.ROTATION_Y,0,300);
        objectAnimator4.setDuration(4000);
        objectAnimator4.setRepeatCount(5);
        objectAnimator4.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator4.start();


        //Scale Effect
        PropertyValuesHolder phx = PropertyValuesHolder.ofFloat(View.SCALE_X,0,1);
        PropertyValuesHolder phpy = PropertyValuesHolder.ofFloat(View.SCALE_Y,0,1);
        ObjectAnimator objectAnimator5 =  ObjectAnimator.ofPropertyValuesHolder(currentText,phx,phpy);
        objectAnimator5.setDuration(4000);
        objectAnimator5.setRepeatCount(5);
        objectAnimator5.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator5.start();



        //AnimatorSet
        ObjectAnimator alpha =  ObjectAnimator.ofFloat(button,View.ALPHA,0,1);
        alpha.setDuration(4000);

        ObjectAnimator trans =  ObjectAnimator.ofFloat(button,View.TRANSLATION_X,-300,0);
        trans.setRepeatCount(5);
        trans.setDuration(4000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alpha);
        animatorSet.start();




    }

    public void onNext(View view) {

        Intent log = new Intent(this,LoginActivity2.class);
        startActivity(log);
    }
}