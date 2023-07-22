package lec.baekseokuni.indyholder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import lec.baekseokuni.indyholder.credential.CredentialListActivity;
import lec.baekseokuni.indyholder.verification.VerificationActivity;

public class MainActivity extends AppCompatActivity {
    View.OnClickListener onStartDeeplink = v -> {
        String testDeeplink = "indy://holder?secret=vStdXgKJNb";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(testDeeplink));
        startActivity(intent);
        finish();
    };
    View.OnClickListener onNavToCredList = v -> {
        Intent intent = new Intent(getApplicationContext(), CredentialListActivity.class);
        startActivity(intent);
    };
    View.OnClickListener onNavToVerify = v -> {
        String verificationUrl = "indy://verify?schemaId=EtAGQxkwjMBgCkG4M6jXjP:2:medical-treatment-confirmation:1.1";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(verificationUrl));
        startActivity(intent);
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnIssueTest = findViewById(R.id.btn_issue_test_cred);
        Button btnNavToCredList1 = findViewById(R.id.btn_nav_to_cred_list1);
        Button btnNavToCredList2 = findViewById(R.id.btn_nav_to_cred_list2);
        btnIssueTest.setOnClickListener(onStartDeeplink);
        btnNavToCredList1.setOnClickListener(onNavToCredList);
        btnNavToCredList2.setOnClickListener(onNavToVerify);
    }
}
