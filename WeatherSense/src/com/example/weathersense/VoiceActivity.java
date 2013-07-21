package com.example.weathersense;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class VoiceActivity extends Activity implements TextToSpeech.OnInitListener{


	private static final int REQUEST_CODE = 1234;
	private ListView wordsList;
	private TextToSpeech tts1;



	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voice_recog);

		ImageButton speakButton = (ImageButton) findViewById(R.id.speakButton);
		tts1 = new TextToSpeech(this, this);
		wordsList = (ListView) findViewById(R.id.list);

		// Disable button if no recognition service is present
		PackageManager pm = getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(
				new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
		if (activities.size() == 0)
		{
			speakButton.setEnabled(false);
			//  speakButton.setText("Recognizer not present");
		}
	}

	@Override
	public void onDestroy() {
		// Don't forget to shut down tts!
		if (tts1 != null) {
			tts1.stop();
			tts1.shutdown();
		}
		super.onDestroy();
	}

	//Handle the action of the button being clicked.
	public void speakButtonClicked(View v)
	{
		startVoiceRecognitionActivity();
	}

	//Fire an intent to start the voice recognition activity.
	private void startVoiceRecognitionActivity()
	{
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice recognition Demo...");
		startActivityForResult(intent, REQUEST_CODE);
	}

	//Handle the results from the voice recognition activity.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
		{
			// Populate the wordsList with the String values the recognition engine thought it heard
			ArrayList<String> matches = data.getStringArrayListExtra(
					RecognizerIntent.EXTRA_RESULTS);
			wordsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
					matches));
			if ("1".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you the current temperature.",TextToSpeech.QUEUE_FLUSH, null);
			} 
			else if ("one".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you the current temperature.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("One".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you the current temperature.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("2".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a more detailed analysis of the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("two".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a more detailed analysis of the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("Two".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a more detailed analysis of the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("to".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a more detailed analysis of the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("To".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a more detailed analysis of the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("too".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a more detailed analysis of the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("Too".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a more detailed analysis of the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("3".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a five day weather forecast.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("three".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a more detailed analysis of the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("Three".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you a more detailed analysis of the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("4".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("four".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("Four".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("for".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else if ("For".contentEquals((String) wordsList.getAdapter().getItem(0))) {
				tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
			}
			else {
				tts1.speak("Unfortunately, that command wasn't recognized as a menu item. Please click the screen and speak to try again.",TextToSpeech.QUEUE_FLUSH, null);
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onInit(int arg0) {
		// TODO Auto-generated method stub

	}




}
