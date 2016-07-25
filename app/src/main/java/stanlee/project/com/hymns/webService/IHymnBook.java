package stanlee.project.com.hymns.webService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Seamfixer on 7/24/2016.
 */
public interface IHymnBook {

    @GET("users/{user}/repos")
    Call<List<String>> getRepoList(@Path("user") String user);

}
