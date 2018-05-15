package linh.com.androidtesttoastdisplay;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class WithSystemDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSystemAlertDialog();
            }
        });
    }

    private void showSystemAlertDialog() {
        ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.READ_CONTACTS },
                0);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Toast.makeText(this, Constant.TOAST_SHOW, Toast.LENGTH_SHORT).show();
    }
}
