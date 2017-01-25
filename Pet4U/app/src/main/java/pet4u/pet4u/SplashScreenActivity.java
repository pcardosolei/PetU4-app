package pet4u.pet4u;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
//import android.R;

import com.github.ybq.android.spinkit.style.FadingCircle;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;

import static java.lang.Thread.sleep;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        
        /*ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        FadingCircle doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);*/


        // TODO: 25/01/2017 check login here; 

        start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        start();
    }

    private void start (){
        //isLogedIn();
        //vamos passar o login a frente;
        boolean login = true;

        if(login){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, MainScreenDono.class);
            startActivity(intent);
        }

    }
}
