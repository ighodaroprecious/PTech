package com.example.myonlineapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Toast mToast;
    RequestQueue queue;
    //      String URL = "http://www.mocky.io/v2/597c41390f0000d002f4dbd1";

    //    String URL = "https://www.googleapis.com/books/v1/volumes/?q=android";
    public static final String ENDPOINT = "http://services.hanselandpetal.com";
    TextView output;
    ProgressBar pb;
//    List<MyTask> tasks ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.progressBar1);
        pb.setVisibility(View.VISIBLE);

        requestData();

//        tasks = new ArrayList<>();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.action_do_task) {
//
//            if (isOnline()) {
//                requestData();
//            } else {
//                Toast.makeText(this, "Network isn't available", Toast.LENGTH_LONG).show();
//            }
//
//
//        }
//        return false;
//    }

    private void requestData() {
//        MyTask task = new MyTask();
//        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"Param 1", "Param 2", "Param 3");
//        queue = Volley.newRequestQueue(this);
//        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                output.setText(response);
//                pb.setVisibility(View.INVISIBLE);
////                Toast.makeText(MainActivity.this, response,Toast.LENGTH_LONG).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("error",error.toString());
//            }
//        });
//        queue.add(request);

//
//        JsonObjectRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, URL,
//                new Response.Listener<JSONArray>() {
//                    JSONObject j = null;
//                    JSONArray result ;
//
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        try {
//                            j = new JSONObject((Map) response);
//                            result = j.getJSONArray("items");
//
//                            for (int i = 0; i < result.length(); i++) {
//                                JSONObject json = result.getJSONObject(i);
//                                String TITLE = json.getString("title");
//
//                                output.setText(TITLE);
//
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                };
//
//        queue.add(jsonObjectRequest);

        FlowersApi service = RetrofitClientInstance.getRetrofitInstance().create(FlowersApi.class);
        Call<List<Books>> call = service.getAllFlowers();
        call.enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                pb.setVisibility(View.INVISIBLE);
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Books>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "try again......", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void generateDataList(final List<Books> body) {

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        BookAdapter bookAdapter = new BookAdapter(body, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bookAdapter);


        bookAdapter.setOnItemClickListener(new BookAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (mToast != null) {
                    mToast.cancel();
                }
                //mToast = Toast.makeText(MainActivity.this, "Clciked " + body.get(position).getName(), Toast.LENGTH_SHORT);
                // mToast.show();

                Intent bundle = new Intent(MainActivity.this, DetailsActivity.class);
                bundle.putExtra("Name", body.get(position).getName());
                bundle.putExtra("Instruction", body.get(position).getInstructions());
                startActivity(bundle);

            }
        });

    }

//    private void updateDisplay(String message) {
//
//    }

//    protected boolean isOnline() {
//        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo netInfo = cm.getActiveNetworkInfo();
//        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

//    private class MyTask extends AsyncTask<String,String, String>{
//
//        @Override
//        protected void onPreExecute() {
//           updateDisplay("Starting task");
//           if (tasks.size() == 0){
//               pb.setVisibility(View.VISIBLE);
//           }
//
//            tasks.add(this);
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            for (int i = 0; i < params.length; i++) {
//                publishProgress("Working with "+params[i]);
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//
//            return "Task complete";
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            updateDisplay(result);
//            tasks.remove(this);
//
//            if (tasks.size() == 0){
//                pb.setVisibility(View.INVISIBLE);
//            }
//        }
//
//        @Override
//        protected void onProgressUpdate(String... values) {
//            updateDisplay(values[0]);
//        }
//    }

//    public static ArrayList<Books> getBooksFromVolley() {
//        final String ID = "id";
//        final String TITLE = "title";
//        final String SUBTITLE = "subtitle";
//        final String AUTHORS = "authors";
//        final String PUBLISHER = "publisher";
//        final String PUBLISHED_DATE = "publishedDate";
//        final String ITEMS = "items";
//
//        ArrayList<Books> books = null;
//        return books;
//    }

}
