package form.form.repository;

import form.form.model.AddPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import form.form.model.StartTripModel;
import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.Optional;
import java.util.List;
import java.util.Optional;
public interface TripsRepository extends JpaRepository<StartTripModel, Integer> {
     List<StartTripModel> findAll();

}
