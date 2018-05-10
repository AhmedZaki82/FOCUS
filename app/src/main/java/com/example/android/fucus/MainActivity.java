package com.example.android.fucus;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;
    MediaPlayer fMediaPlayer;
    MediaPlayer tMediaPlayer;
    MediaPlayer wMediaPlayer;

    private AudioManager mAudioManager;
    private AudioManager fAudioManager;
    private AudioManager tAudioManager;
    private AudioManager wAudioManager;



    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {

            if (i == AudioManager.AUDIOFOCUS_LOSS){

                release();

            }else if (i == AudioManager.AUDIOFOCUS_GAIN) {

                mMediaPlayer.start();
                mMediaPlayer.setVolume(1f,1f);


            }else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {

                mMediaPlayer.pause();

            }else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                mMediaPlayer.setVolume(1f,1f);

            }else if (i == AudioManager.AUDIOFOCUS_REQUEST_FAILED) {

                mMediaPlayer.release();
            }
        }
    };

    AudioManager.OnAudioFocusChangeListener fOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {

            if (i == AudioManager.AUDIOFOCUS_GAIN) {

                fMediaPlayer.start();
                fMediaPlayer.setVolume(1,1);


            }else if (i == AudioManager.AUDIOFOCUS_LOSS) {

                releaseF();

            }else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {

                fMediaPlayer.pause();

            }else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                fMediaPlayer.setVolume(1f,1f);

            }else if (i == AudioManager.AUDIOFOCUS_REQUEST_FAILED) {

                fMediaPlayer.release();
            }

        }
    };

    AudioManager.OnAudioFocusChangeListener tOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int i) {

                    if (i == AudioManager.AUDIOFOCUS_LOSS) {

                        releaseT();

                    }else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {

                        tMediaPlayer.pause();

                    }else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                        tMediaPlayer.setVolume(1f,1f);

                    }else if (i == AudioManager.AUDIOFOCUS_REQUEST_FAILED) {

                        tMediaPlayer.release();

                    }else if (i == AudioManager.AUDIOFOCUS_GAIN) {

                        tMediaPlayer.start();
                        tMediaPlayer.setVolume(1,1);

                    }
                }
            };

    AudioManager.OnAudioFocusChangeListener wOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int i) {

                    if (i == AudioManager.AUDIOFOCUS_GAIN) {

                        wMediaPlayer.start();
                        wMediaPlayer.setVolume(1,1);


                    }else if (i == AudioManager.AUDIOFOCUS_LOSS) {

                        releaseW();

                    }else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {

                        wMediaPlayer.pause();

                    }else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                        wMediaPlayer.setVolume(1f,1f);

                    }else if (i == AudioManager.AUDIOFOCUS_REQUEST_FAILED) {

                        wMediaPlayer.release();
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        fAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        tAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        wAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        Button buttonPlayK = (Button) findViewById(R.id.buttonPlayK);
        final Button buttonPauseK = (Button) findViewById(R.id.buttonPauseK);
        final Button buttonStopK = (Button) findViewById(R.id.buttonStopK);

        Button buttonPlayF = (Button) findViewById(R.id.buttonPlayF);
        final Button buttonPauseF = (Button) findViewById(R.id.buttonPauseF);
        final Button buttonStopF = (Button) findViewById(R.id.buttonStopF);

        Button buttonPlayT = (Button) findViewById(R.id.buttonPlayT);
        final Button buttonPauseT = (Button) findViewById(R.id.buttonPauseT);
        final Button buttonStopT = (Button) findViewById(R.id.buttonStopT);

        Button buttonPlayW = (Button) findViewById(R.id.buttonPlayW);
        final Button buttonPauseW = (Button) findViewById(R.id.buttonPauseW);
        final Button buttonStopW = (Button) findViewById(R.id.buttonStopW);

        buttonPlayW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonPauseW.setVisibility(View.VISIBLE);
                buttonStopW.setVisibility(View.VISIBLE);

                buttonPauseF.setVisibility(View.INVISIBLE);
                buttonPauseK.setVisibility(View.INVISIBLE);
                buttonPauseT.setVisibility(View.INVISIBLE);
                buttonStopF.setVisibility(View.INVISIBLE);
                buttonStopK.setVisibility(View.INVISIBLE);
                buttonStopT.setVisibility(View.INVISIBLE);

                int result = wAudioManager.requestAudioFocus(wOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {



                    if (wMediaPlayer == null) {

                        wMediaPlayer = MediaPlayer.create(MainActivity.this,
                                R.raw.when_the_hurt_is_over);

                        wMediaPlayer.start();
                    } else {

                        wMediaPlayer.start();
                    }
                }

            }
        });

        buttonPauseW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wMediaPlayer.pause();
            }
        });

        buttonStopW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wMediaPlayer.stop();
                releaseW();
            }
        });

        buttonPlayT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonPauseT.setVisibility(View.VISIBLE);
                buttonStopT.setVisibility(View.VISIBLE);

                buttonPauseF.setVisibility(View.INVISIBLE);
                buttonPauseK.setVisibility(View.INVISIBLE);
                buttonPauseW.setVisibility(View.INVISIBLE);

                buttonStopF.setVisibility(View.INVISIBLE);
                buttonStopK.setVisibility(View.INVISIBLE);
                buttonStopW.setVisibility(View.INVISIBLE);

                int resultT = tAudioManager.requestAudioFocus(tOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE);

                if (resultT == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    if (tMediaPlayer == null) {

                        tMediaPlayer = MediaPlayer.create(MainActivity.this,
                                R.raw.the_sky_is_crying);
                        tMediaPlayer.start();
                    } else {

                        tMediaPlayer.start();
                    }
                }


            }
        });

        buttonPauseT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tMediaPlayer.pause();
            }
        });

        buttonStopT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tMediaPlayer.stop();
                releaseT();
            }
        });

        buttonPlayF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonPauseF.setVisibility(View.VISIBLE);
                buttonStopF.setVisibility(View.VISIBLE);

                buttonPauseK.setVisibility(View.INVISIBLE);
                buttonPauseT.setVisibility(View.INVISIBLE);
                buttonPauseW.setVisibility(View.INVISIBLE);

                buttonStopK.setVisibility(View.INVISIBLE);
                buttonStopT.setVisibility(View.INVISIBLE);
                buttonStopW.setVisibility(View.INVISIBLE);

                int resultF = fAudioManager.requestAudioFocus(fOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (resultF == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                    if (fMediaPlayer == null) {
                        fMediaPlayer = MediaPlayer.create(MainActivity.this,
                                R.raw.finally_forgot_your_name);
                        fMediaPlayer.start();
                    } else {

                        fMediaPlayer.start();
                    }
                }


            }
        });

        buttonPauseF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fMediaPlayer.pause();
            }
        });

        buttonStopF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fMediaPlayer.stop();
                releaseF();
            }
        });

        buttonPlayK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonPauseK.setVisibility(View.VISIBLE);
                buttonStopK.setVisibility(View.VISIBLE);

                buttonPauseF.setVisibility(View.INVISIBLE);
                buttonPauseT.setVisibility(View.INVISIBLE);
                buttonPauseW.setVisibility(View.INVISIBLE);

                buttonStopF.setVisibility(View.INVISIBLE);
                buttonPauseT.setVisibility(View.INVISIBLE);
                buttonStopW.setVisibility(View.INVISIBLE);

                int resultm = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK);

                if (resultm == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    if (mMediaPlayer == null) {

                        mMediaPlayer = MediaPlayer.create(MainActivity.this,
                                R.raw.killing_my_love);
                        mMediaPlayer.start();
                    } else {

                        mMediaPlayer.start();
                    }
                }


            }
        });

        buttonPauseK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMediaPlayer.pause();
            }
        });

        buttonStopK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMediaPlayer.stop();
                release();
            }
        });


    }

    private void release() {

        if (mMediaPlayer != null) {

            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private void releaseF() {

        if (fMediaPlayer != null) {

            fMediaPlayer.release();
            fMediaPlayer = null;
        }
    }

    private void releaseT() {

        if (tMediaPlayer != null) {

            tMediaPlayer.release();
            tMediaPlayer = null;
        }
    }

    private void releaseW() {

        if (wMediaPlayer != null) {

            wMediaPlayer.release();
            wMediaPlayer = null;
        }
    }
    }

