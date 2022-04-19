package com.example.teamb4spring.bootstrap;



import com.example.teamb4spring.base.BaseComponent;
import com.example.teamb4spring.domain.Episode;
import com.example.teamb4spring.domain.Movie;
import com.example.teamb4spring.domain.Person;
import com.example.teamb4spring.domain.Position;
import com.example.teamb4spring.domain.PositionType;
import com.example.teamb4spring.domain.Season;
import com.example.teamb4spring.domain.TvShow;
import com.example.teamb4spring.domain.User;
import com.example.teamb4spring.service.MovieService;
import com.example.teamb4spring.service.PersonService;
import com.example.teamb4spring.service.PositionService;
import com.example.teamb4spring.service.TvShowService;
import java.util.Date;
import com.example.teamb4spring.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
	private final PersonService personService;
	private final PositionService positionService;

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



		List<Episode> episodeList = List.of(
				Episode.builder().title("THE HEIST").description("The heist takes place").build(),
				Episode.builder().title("THE TALK").description("The talk takes place").build()
		);

		List<Season> season = List.of(
				Season.builder()
						.seasonNumber(1)
						.episodes(new HashSet(episodeList)).build()
		);

		List<TvShow> tvShows = List.of(
				TvShow.builder().title("La Casa De Papel")
						.description("Psychological thriller").releaseYear(2018).numberOfSeasons(4).seasons(new HashSet(season)).build(),
				TvShow.builder().title("Dexter").numberOfSeasons(4)
						.description("Mystery ").releaseYear(2018).build(),
				TvShow.builder().title("Friends").numberOfSeasons(4)
						.description("Comedy").releaseYear(2010).build()
		);

		List<Person> personList = List.of(
				Person.builder().firstName("John").lastName("Kitsou").dateOfBirth(new Date()).build(),
				Person.builder().firstName("Mitsos").lastName("Titsou").dateOfBirth(new Date()).build(),
				Person.builder().firstName("Takis").lastName("Ritsou").dateOfBirth(new Date()).build(),
				Person.builder().firstName("Kostas").lastName("Farel").dateOfBirth(new Date()).build(),
				Person.builder().firstName("Petros").lastName("Parel").dateOfBirth(new Date()).build(),
				Person.builder().firstName("Pitsos").lastName("Papadaks").dateOfBirth(new Date()).build(),
				Person.builder().firstName("Anna").lastName("Trifous").dateOfBirth(new Date()).build(),
				Person.builder().firstName("Konna").lastName("Para").dateOfBirth(new Date()).build(),
				Person.builder().firstName("Katerina").lastName("Tirinini").dateOfBirth(new Date()).build(),
				Person.builder().firstName("Pantelis").lastName("Karas").dateOfBirth(new Date()).build()
		);

		List<Position> positionList = List.of(
				Position.builder().movie(movies.get(0)).description("Role 1").positionType(PositionType.ACTOR).person(personList.get(0)).build(),
				Position.builder().movie(movies.get(0)).description("Role 1").positionType(PositionType.ACTOR).person(personList.get(1)).build(),
				Position.builder().movie(movies.get(0)).description("Role 2").positionType(PositionType.ACTOR).person(personList.get(2)).build(),
				Position.builder().tvShow(tvShows.get(0)).description("Main role").positionType(PositionType.ACTOR).person(personList.get(3)).build(),
				Position.builder().tvShow(tvShows.get(0)).description("Second role").positionType(PositionType.ACTOR).person(personList.get(4)).build(),
				Position.builder().tvShow(tvShows.get(0)).description("Komparsos").positionType(PositionType.ACTOR).person(personList.get(6)).build(),
				Position.builder().tvShow(tvShows.get(0)).description("director 1").positionType(PositionType.DIRECTOR).person(personList.get(6)).build(),
				Position.builder().tvShow(tvShows.get(0)).description("director 2").positionType(PositionType.DIRECTOR).person(personList.get(7)).build(),
				Position.builder().tvShow(tvShows.get(0)).description("producer 1").positionType(PositionType.PRODUCER).person(personList.get(8)).build(),
				Position.builder().tvShow(tvShows.get(0)).description("producer 2").positionType(PositionType.PRODUCER).person(personList.get(9)).build()
				);

		List<User> users = List.of(
				User.builder().firstname("DaveFirst").lastname("DaveLast").age(43).email("dave@gmail.com").address("thessaloniki").build(),
				User.builder().firstname("JaneFirst").lastname("JaneLast").age(43).email("jane@gmail.com").address("athens").build(),
				User.builder().firstname("SteveFirst").lastname("SteveLast").age(43).email("steve@gmail.com").address("patra").build(),
				User.builder().firstname("MariaFirst").lastname("MariaLast").age(43).email("maria@gmail.com").address("heraklion").build()
		);

		movieService.createAll(movies);
		tvShowService.createAll(tvShows);
		userService.createAll(users);
		personService.createAll(personList);
		positionService.createAll(positionList);
	}
}
