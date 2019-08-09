For Activty You Just Need to Use This Method :

###########################################################
----------------------------------------------------------------------------------------------------------------------------

private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99 ;  This Code is Really Important

                      public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       if(checkLocationPermission()) {
            Toast.makeText(getActivity(), "" +DeviceClass.getMacAddress(), Toast.LENGTH_SHORT).show();
        }
        
        
        
        
            //permission check for the activity
    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(getActivity())
                        .setTitle("Permission")
                        .setMessage("Please Share/on Your Location")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                 ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

                            }
                        })
                        .create()
                        .show();


            } else {
//                // No explanation needed, we can request the permission.
              ActivityCompat.requestPermissions(getActivity(),
                       new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                       MY_PERMISSIONS_REQUEST_LOCATION);
               
            }

            return false;
        } else {

            return true;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){


            case MY_PERMISSIONS_REQUEST_LOCATION:{
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(), "Permission Granted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(),MainActivity.class));


                }

            }

        }
    }
        
        
        
    }
