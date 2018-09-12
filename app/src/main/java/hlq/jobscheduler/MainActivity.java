package hlq.jobscheduler;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hlq.view.activity.TestActivity3;

public class MainActivity extends AppCompatActivity {

    private String name[] = {"大黄","开放","老胡","康康","保鲜膜","测试"};

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        List<ShortcutInfo> infos = new ArrayList<>();

        Log.d("sdsadsad",shortcutManager.getMaxShortcutCountPerActivity()+"");
        for(int i = 0;i < shortcutManager.getMaxShortcutCountPerActivity(); i++){
            Intent intent = new Intent(this, TestActivity3.class);
            intent.setAction(Intent.ACTION_VIEW);
            intent.putExtra("msg", "我和" + name[i] + "聊天");
            ShortcutInfo info = new ShortcutInfo.Builder(this, "id" + i)
                    .setShortLabel(name[i])
                    .setLongLabel("朋友:" + name[i])
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher_round))
                    .setIntent(intent)
                    .build();
            infos.add(info);
        }
        shortcutManager.setDynamicShortcuts(infos);
    }
}
