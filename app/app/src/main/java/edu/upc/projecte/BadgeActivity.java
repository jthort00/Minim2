package edu.upc.projecte;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BadgeActivity extends AppCompatActivity {

    private ApiService apiService;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_badge);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        apiService = RetrofitClient.getClient().create(ApiService.class);

    }

    private void fetchBadges() {
        apiService.getBadges(username).enqueue(new Callback<List<Badge>>() {
            @Override
            public void onResponse(Call<List<Badge>> call, Response<List<Badge>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Badge> itemList = response.body();
                    BadgeItemAdapter adapter = new BadgeItemAdapter(itemList, BadgeActivity.this);
                    RecyclerView recyclerView = findViewById(R.id.badges_recycler_view);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(BadgeActivity.this, "Failed to load badges", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Badge>> call, Throwable t) {
                Toast.makeText(BadgeActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}