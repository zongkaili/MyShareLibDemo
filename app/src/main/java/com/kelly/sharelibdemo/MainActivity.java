package com.kelly.sharelibdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.idealsee.share.ShareApi;
import com.idealsee.share.ShareError;
import com.idealsee.share.ShareListener;
import com.idealsee.share.SharePlatform;
import com.idealsee.share.ShareType;
import com.idealsee.share.content.BaseShareContent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1,button2,button3,button4,button5;
    private BaseShareContent content;//测试用的分享内容
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        setListener();
    }

    private void initView() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
    }

    private void initData() {
        content = new BaseShareContent("标题","内容",null,"",null,null);
    }

    private void setListener() {
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                Toast.makeText(this,getResources().getString(R.string.tip_shareto_weixin),Toast.LENGTH_LONG).show();
                share(SharePlatform.WEIXIN,content,ShareType.SHARE_IMAGE);
                break;
            case R.id.button2:
                Toast.makeText(this,getResources().getString(R.string.tip_shareto_pyq),Toast.LENGTH_LONG).show();
                share(SharePlatform.WEIXIN_PYQ,content,ShareType.SHARE_IMAGE);
                break;
            case R.id.button3:
                Toast.makeText(this,getResources().getString(R.string.tip_shareto_weibo),Toast.LENGTH_LONG).show();
                share(SharePlatform.SINA_WEIBO,content,ShareType.SHARE_IMAGE);
                break;
            case R.id.button4:
                Toast.makeText(this,getResources().getString(R.string.tip_shareto_sms),Toast.LENGTH_LONG).show();
                share(SharePlatform.SHORT_MESSAGE,content,ShareType.SHARE_IMAGE);
                break;
            case R.id.button5:
                Toast.makeText(this,getResources().getString(R.string.tip_shareto_system),Toast.LENGTH_LONG).show();
                share(SharePlatform.SYSTEM_SHARE,content,ShareType.SHARE_IMAGE);
                break;
            default:
                break;
        }
    }

    private void share(SharePlatform sharePlatform,BaseShareContent content,ShareType shareType) {
        if(ShareApi.isPlatformInstalled(this,sharePlatform)){
            switch (sharePlatform){
                case WEIXIN:
                case WEIXIN_PYQ:
                    Toast.makeText(this,getResources().getString(R.string.tip_not_install_weixin),Toast.LENGTH_LONG).show();
                    break;
                case SINA_WEIBO:
                    Toast.makeText(this,getResources().getString(R.string.tip_not_install_weibo),Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
            return;
        }
        ShareApi.share(this, sharePlatform, content, new ShareListener() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(ShareError shareError) {

            }
        },shareType);
    }
}
