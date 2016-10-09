package tutorial.maps.google.googlemapsapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button_map, button_photo;
    int TAKE_PHOTO_CODE = 0;
    int SELECT_FILE=1;
    ImageView userImage ;
    static Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getActionBar().setTitle("Home page");
        userImage = (ImageView) findViewById(R.id.profilePic);
        button_map = (Button) findViewById(R.id.main_btn_maps);
        button_photo = (Button) findViewById(R.id.main_btn_photo);

    }

    public void onClickOfMapButton(View v) {
        //This code redirects the from main page to the maps page.
        Intent redirect = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(redirect);
    }

    public void onClickOfPhotoButton(View v) {
        //This code redirects to the photo activity.
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
    }





    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
            Log.d("CameraDemo", "Pic saved");
        }
        if(requestCode == SELECT_FILE && resultCode == RESULT_OK){
            Uri imageUri = data.getData();
            Bitmap bm=null;
            try {
                bm = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            } catch(Exception E){};
            photo=bm;
            userImage.setImageBitmap(bm);

            Log.d("CameraDemo", "Gallery pic saved");
        }
    }
    public void uploadClick(View v){
        Intent intent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);



    }






}
