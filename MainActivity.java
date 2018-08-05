package windows.app.android;







import android.os.*;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.*;

import android.graphics.Paint.Style;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.widget.ImageView;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

import java.lang.Object;
import java.util.Random;

import java.lang.Object;
import android.view.View;


import android.text.format.Time;



import android.view.View.OnTouchListener;


public class MainActivity extends Activity
{
	Bitmap bm ;
	ImageView mI;
	int w;
	int h,a,h1,w1,ws,hs,mx,my;
	int[]x=new int[8];
	Bitmap newImage;
	int i;
	int hh;
	int rrr;
	int[] y=new int[8];
	int[] xxx=new int[8];
	Rect r1=new Rect();
	Rect r2=new Rect();
	Time time = new Time();

	Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
			ddraw();
			timerHandler.postDelayed(this, 100);


		}};


	public static wwindows mywindow[]=new wwindows[8];

	class wwindows{

		protected Paint ppaint;





		public Bitmap mBitmap;



		protected	Canvas canvass;


		public int backcolor;
		public int barcolor; 
public int left;
public int top;
public int ww;
public int hh;

		protected String title;
		


		public wwindows (){


			mBitmap = Bitmap.createBitmap (mx, my, Bitmap.Config.RGB_565); 





			canvass=new Canvas(mBitmap);




			ppaint=new Paint();



			ppaint.setTextSize(10);

			backcolor=0;
			bar(1,my/12,mx-1,my-1,0xff000000);
			setTitle("window");
			cls();


		}
		public void setTitle(String value) {
			title=value;


			bar(1,1,mx-2,my/12-2,barcolor);





			text (3,my/11-3,title,0xffffffff,my/13);


		}

		public String getTitle(){
			return title;
		}



		public void cls(){


			bar(1,my/12,mx-2,my-1-my/12,backcolor);



		}



		public void bar(int x,int y,int w,int h,int c){



			ppaint.setColor(c);


			canvass.drawRect(x,y,x+w,y+h,ppaint);




		}

		public void text(int x,int y, String s,int c,float ts){


			ppaint.setColor(c);
		ppaint.setTextSize(ts);
			canvass.drawText(s,x,y,ppaint);




		}

	};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		w1 =size.x;
		h1=size.y;


		mI = (ImageView)findViewById(R.id.ch);

		bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		rrr=bm.getWidth();

		mx=w1*5/10;
		my=h1*5/10;

		newImage = Bitmap.createBitmap(w1,h1,Bitmap.Config.ARGB_8888);

		


		mI.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {

					int action = event.getAction();
					int xx = (int) event.getX();
					int yy = (int) event.getY();

int i=0;
					for(i=0;i<8;i++){
						if( action==MotionEvent.ACTION_DOWN && xx>mywindow[x[i]].left && xx<mywindow[x[i]].left+(mx) && yy> mywindow[x[i]].top && yy < mywindow[x[i]].top+(my)){
tones(1000);
zorder(i);

i=8;
						}}
					return true;

				}});
				
				


		for (int t=0;t < 8;t++){




	


				mywindow[t]=new wwindows();
















				mywindow[t].barcolor=0xff4444ff;



				mywindow[t].backcolor=0xffffffff;


x[t]=7-t;

	if(t==7) mywindow[t].setTitle("hora");
	if(t==6) mywindow[t].setTitle("minutos");
	if(t==5) mywindow[t].setTitle("dia");
	
	if(t==4) mywindow[t].setTitle("mes");
	if(t==3) mywindow[t].setTitle("ano");
	if(t==2) mywindow[t].setTitle("segundos");
	
	if(t==1) mywindow[t].setTitle("dia semana");
	if(t==0) mywindow[t].setTitle("mes");
	


				mywindow[t].cls();
				mywindow[t].left=(mx/20*8)-t*(mx/20);
				mywindow[t].top=t*(my/12);


			


		}


		
				

		timerHandler.postDelayed(timerRunnable, 0);
    }

	public void ddraw(){



		Canvas c = new Canvas(newImage);
		Paint myPaint = new Paint();
		myPaint.setColor(Color.rgb(128, 0, 128));

		c.drawRect(0, 0,w1, h1, myPaint);

		
		time.setToNow();



		
		String ss=time.format("%H");


		mywindow[7].cls();


		mywindow[7].text(3,my/2,ss,0xff000000,my/3);
		
		
	ss=time.format("%M");


		mywindow[6].cls();


		mywindow[6].text(3,my/2,ss,0xff000000,my/3);
		
		ss=time.format("%d");


		mywindow[5].cls();


		mywindow[5].text(3,my/2,ss,0xff000000,my/3);

		ss=time.format("%m");


		mywindow[4].cls();


		mywindow[4].text(3,my/2,ss,0xff000000,my/3);
		
		ss=time.format("%Y");


		mywindow[3].cls();


		mywindow[3].text(3,my/2,ss,0xff000000,my/3);
		
		
		ss=time.format("%S");


		mywindow[2].cls();


		mywindow[2].text(3,my/2,ss,0xff000000,my/3);
		


		ss=time.format("%A");


		mywindow[1].cls();


		mywindow[1].text(3,my/2,ss,0xff000000,my/3);
		

		ss=time.format("%B");


		mywindow[0].cls();


		mywindow[0].text(3,my/2,ss,0xff000000,my/3);
		
		
		for (int t=7;t > -1;t--){

			c.drawBitmap(mywindow[x[t]].mBitmap, mywindow[x[t]].left, mywindow[x[t]].top,  myPaint  );
		}
		mI.setImageBitmap(newImage);
		
		
	}



	

public void zorder(int z){
	
	int i;
	int aa=x[z];
	for (i=z;i>0;i--){
		x[i]=x[i-1];
		
	}
	x[0]=aa;
	ddraw();
}





	public void tones (double fr){
		int sr = 44100;

		int buffsize = AudioTrack.getMinBufferSize(sr,AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
        // create an audiotrack object
        AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
											   sr, AudioFormat.CHANNEL_OUT_MONO,
											   AudioFormat.ENCODING_PCM_16BIT, buffsize,
											   AudioTrack.MODE_STREAM);

        short samples[] = new short[buffsize];
        int amp = 10000;
        double twopi = 8.*Math.atan(1.);

        double ph = 0.0;

        // start audio
		audioTrack.play();

		// synthesis loop


		for(int i=0; i < buffsize; i++){
			samples[i] = (short) (amp*Math.sin(ph));
			ph += twopi*fr/sr;
		}
		audioTrack.write(samples, 0, buffsize);

		audioTrack.stop();
		audioTrack.release();


	}
	



}




