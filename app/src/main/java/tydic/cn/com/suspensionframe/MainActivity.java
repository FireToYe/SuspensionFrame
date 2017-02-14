package tydic.cn.com.suspensionframe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tydic.cn.com.suspensionframe.service.FloatWindowService;

public class MainActivity extends AppCompatActivity {
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnGo = (Button) findViewById(R.id.btn_go);
        btnGo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FloatWindowService.class);
            startService(intent);
            finish();
        });
    }

}
