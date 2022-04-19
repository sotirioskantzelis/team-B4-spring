package com.example.teamb4spring.bootstrap;



import com.example.teamb4spring.base.BaseComponent;
import com.example.teamb4spring.domain.Movie;
import com.example.teamb4spring.domain.TvShow;
import com.example.teamb4spring.domain.User;
import com.example.teamb4spring.service.MovieService;
import com.example.teamb4spring.service.TvShowService;
import com.example.teamb4spring.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("generate-basic-content")
@RequiredArgsConstructor
public class BasicSampleContentCreator extends BaseComponent implements CommandLineRunner {
	private final MovieService movieService;
	private final TvShowService tvShowService;
	private final UserService userService;


	@Override
	public void run(String... args) throws Exception {

		//@formatter:off
		List<Movie> movies = List.of(
				Movie.builder().duration(123).title("Inception")
						.description("Psychological thriller").releaseYear(2018).build(),
		Movie.builder().duration(120).title("The Call")
				.description("Sci-fi ").releaseYear(2018).build(),
		Movie.builder().duration(123).title("Django")
				.description("Adventure").releaseYear(2010).build());

		List<TvShow> tvShows = List.of(
				TvShow.builder().title("La Casa De Papel")
						.description("Psychological thriller").releaseYear(2018).numberOfSeasons(4).build(),
				TvShow.builder().title("Dexter").numberOfSeasons(4)
						.description("Mystery ").releaseYear(2018).build(),
				TvShow.builder().title("Friends").numberOfSeasons(4)
						.description("Comedy").releaseYear(2010).build());

		List<User> users = List.of(
				User.builder().firstname("DaveFirst").lastname("DaveLast").age(43).email("dave@gmail.com").address("thessaloniki").build(),
				User.builder().firstname("JaneFirst").lastname("JaneLast").age(43).email("jane@gmail.com").address("athens").build(),
				User.builder().firstname("SteveFirst").lastname("SteveLast").age(43).email("steve@gmail.com").address("patra").build(),
				User.builder().firstname("MariaFirst").lastname("MariaLast").age(43).email("maria@gmail.com").address("heraklion").build()
		);

		movieService.createAll(movies);
		tvShowService.createAll(tvShows);
		userService.createAll(users);
	}
}
