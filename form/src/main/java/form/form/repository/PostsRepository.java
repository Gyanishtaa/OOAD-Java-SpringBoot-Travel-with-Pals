package form.form.repository;

import form.form.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import form.form.model.AddPostModel;
import java.util.Optional;
import java.util.List;

public interface PostsRepository extends JpaRepository<AddPostModel, Integer> {
    List<AddPostModel> findAll();

}