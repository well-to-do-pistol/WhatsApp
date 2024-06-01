package com.example.easychat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.easychat.model.UserModel;
import com.example.easychat.utils.AndroidUtil;
import com.example.easychat.utils.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d("Myfault","Myfault");

//        if( FirebaseUtil.isLoggedIn() && getIntent().getExtras()!=null){
//            Log.d("Myfault","Myfault1");
//            //from notification
//            String userId = getIntent().getExtras().getString("userId"); //从FCM拿到对方Id, 及时查看当前对话
//            FirebaseUtil.allUserCollectionReference().document(userId).get()
//                    .addOnCompleteListener(task -> {
//                        if(task.isSuccessful()){
//                            UserModel model = task.getResult().toObject(UserModel.class);
//
//                            Intent mainIntent = new Intent(this,MainActivity.class); //点进通知时加多一个主界面
//                            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                            startActivity(mainIntent);
//
//                            Intent intent = new Intent(this, ChatActivity.class);
//                            AndroidUtil.passUserModelAsIntent(intent,model);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            startActivity(intent);
//                            finish();
//                        }
//                    });
//
//        }else {
            Log.d("Myfault","Myfault2");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(FirebaseUtil.isLoggedIn()){
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    }else {
                        startActivity(new Intent(SplashActivity.this,LoginPhoneNumberActivity.class));
                    }
                    finish();
                }
            },1000);
//        }
    }
}