package pet4u.pet4u.controller.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pet4u.pet4u.R;
import pet4u.pet4u.managers.UserLoginManager;
import pet4u.pet4u.UserToken;

public class MainActivity extends AppCompatActivity {

    private TextView accessToken;
    private TextView tokenType;
    private TextView grantType;
    private TextView refreshToken;
    private TextView expiresIn;
    private TextView scope;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accessToken = (TextView) findViewById(R.id.access_token);
        tokenType = (TextView) findViewById(R.id.token_type);
        grantType = (TextView) findViewById(R.id.grant_type);
        refreshToken = (TextView) findViewById(R.id.refresh_token);
        expiresIn = (TextView) findViewById(R.id.expires_in);
        scope = (TextView) findViewById(R.id.scope);
        //button = (Button) findViewById(R.id.main_button);
    }

    @Override
    protected void onResume() {
        super.onResume();

        UserToken userToken = UserLoginManager.getInstance().getUserToken();

        if(userToken!=null) {
            accessToken.setText(userToken.getAccessToken());
            tokenType.setText(userToken.getTokenType());
            grantType.setText(userToken.getGrantType());
            refreshToken.setText(userToken.getRefreshToken());
            expiresIn.setText(Math.ceil(userToken.getExpiresIn() / 60) + " minutes.");
            scope.setText(userToken.getScope());
        } else {
            Log.e("MainActivity->", "onResume ERROR: userToken is NULL");
        }

    }
}
