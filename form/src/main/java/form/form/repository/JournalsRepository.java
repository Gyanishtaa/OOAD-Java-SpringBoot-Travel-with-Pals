package form.form.repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
//import form.form.model.AddPostModel;
import form.form.model.JournalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author HP
 */
public interface JournalsRepository extends JpaRepository <JournalModel, Integer>{
    List<JournalModel> findAll();

}
