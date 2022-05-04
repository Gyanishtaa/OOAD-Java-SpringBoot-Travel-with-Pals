/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.form.service;
import form.form.model.AddPostModel;
import form.form.model.JournalModel;
import form.form.model.StartTripModel;
import form.form.model.UsersModel;
import form.form.repository.PostsRepository;
import form.form.repository.TripsRepository;
import form.form.repository.UsersRepository;
import form.form.repository.JournalsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author HP
 */
@Service
public class UsersService {
   
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;
    private final JournalsRepository journalsRepository;
    private final TripsRepository tripsRepository;
    public UsersService(UsersRepository usersRepository,PostsRepository postsRepository,JournalsRepository journalsRepository,TripsRepository tripsRepository){
        this.usersRepository=usersRepository;
        this.postsRepository=postsRepository;
        this.journalsRepository=journalsRepository;
        this.tripsRepository=tripsRepository;
    }
    public UsersModel registerUser(String login, String password, String email){
        if(login==null && password==null){
            return null;
        }
        else{
            UsersModel usersModel=new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return usersRepository.save(usersModel);
        }
    }
    public UsersModel authenticate(String login,String password){
       return usersRepository.findByLoginAndPassword(login,password).orElse(null);
       
    }
    public AddPostModel addPost(Integer uid,String filename, String caption, String locatn ){
       if(filename==null && caption==null){
            return null;
        }
        else{
            AddPostModel addPostModel=new AddPostModel();
            addPostModel.setUid(uid);
           addPostModel.setPhotos(filename);
           addPostModel.setCaption(caption);
           addPostModel.setLocatn(locatn);
         //  addPostModel.setFriends(friends);
            return postsRepository.save(addPostModel);
        }
        }
    public JournalModel addJournal(Integer uid, String jtitle, String text, String locatn){
        if(jtitle==null){
            return null;
        }
        else{
            JournalModel journalModel=new JournalModel();
            journalModel.setUid(uid);
            journalModel.setJtitle(jtitle);
            journalModel.setText(text);
            journalModel.setLocatn(locatn);
            return journalsRepository.save(journalModel);
        }
    }
    public StartTripModel addTrip(Integer uid, String locations,String start1_date,String end1_date, String hotelname,String travelmode, String friends){
        if(locations==null ){
            return null;
        }

        else{
            StartTripModel startTripModel=new StartTripModel();
            startTripModel.setUid(uid);
            startTripModel.setLocations(locations);
            startTripModel.setStart1_date(start1_date);
            startTripModel.setEnd1_date(end1_date);
            startTripModel.setHotelname(hotelname);
            startTripModel.setTravelmode(travelmode);
            startTripModel.setFriends(friends);
            return tripsRepository.save(startTripModel);
        }
    }
   /* public StartTripModel retrieveTripRecords(){
        return tripsRepository.findAll();

    }*/

    public List< StartTripModel > retrieveTripRecords() {
        return tripsRepository.findAll();
    }
    public List< JournalModel > retrieveJournalRecords() {
        return journalsRepository.findAll();
    }
    public List<AddPostModel> retrievePostRecords(){return postsRepository.findAll();}

}
