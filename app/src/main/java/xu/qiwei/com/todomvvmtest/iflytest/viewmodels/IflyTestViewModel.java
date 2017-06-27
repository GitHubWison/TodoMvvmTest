package xu.qiwei.com.todomvvmtest.iflytest.viewmodels;

import android.databinding.ObservableField;

import com.iflytek.cloud.SpeechError;

import xu.qiwei.com.iflyvoice.Dictation;

/**
 * Created by xuqiwei on 17-6-16.
 */

public class IflyTestViewModel {
    private Dictation diction;
    public final ObservableField<String> testmsg = new ObservableField<>();
    public final void startVoice(){


        diction.startDictation(new Dictation.DictionResult() {
            @Override
            public void onDictionSuccess(String resultStr) {
                testmsg.set(resultStr);
            }

            @Override
            public void onDictionFailure(SpeechError var1) {

            }
        });
    }

    public void setDiction(Dictation diction) {
        this.diction = diction;
    }

}
