/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.form.controller;
//import form.form.model.UsersModel;
import form.form.model.JournalModel;
import form.form.model.StartTripModel;
import form.form.model.UsersModel;
import form.form.model.AddPostModel;
import form.form.service.UsersService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;

import java.text.DateFormat;
/**
 *
 * @author HP
 */
@Controller
public class UsersController {
    private final UsersService usersService;
    public static Integer uid1;
    public static String uploadDirectory=System.getProperty("user.dir") + "/src/main/java/imagedata";
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest",new UsersModel());
        return "register_page";
    }
    @GetMapping("/feed")
    public String getFeedPage(Model model){
        return "feed_page";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.addAttribute("loginRequest",new UsersModel());
        return "login_page";
    }
    @GetMapping("/start_trip")
    public String getStartTripPage(Model model)
    {
        model.addAttribute("startTripRequest",new StartTripModel());
        return "start_trip_page";
    }
    @GetMapping("/displayTrips")
    public String getDisplayTripsPage(Model model)
    {
        model.addAttribute("retrieveTrips",usersService.retrieveTripRecords());
        return "display_trips";

    }
    @GetMapping("/displayPosts")
    public String getDisplayPostsPage(Model model)
    {
        model.addAttribute("retrievePosts",usersService.retrievePostRecords());
        return "display_posts";

    }
    @GetMapping("/displayJournals")
    public String getDisplayJournalsPage(Model model)
    {
        model.addAttribute("retrieveJournals",usersService.retrieveJournalRecords());
        return "display_journals";

    }
    @GetMapping("/add_post")
    public String getAddPostPage(Model model)
    {
        model.addAttribute("addPostUser",new UsersModel());
        model.addAttribute("addPostRequest",new AddPostModel());
        return "add_post_page";
    }

    @GetMapping("/journal")
    public String getJournalPage(Model model)
    {
        model.addAttribute("journalAddRequest",new JournalModel());
        return "journal_page";
    }



   @PostMapping("/add_post")
    public String add_post(Model model,@ModelAttribute UsersModel usersModel,@ModelAttribute AddPostModel addPostModel,@RequestParam("img") MultipartFile file) {
       StringBuilder filenames = new StringBuilder();
       String filename = file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
       Path fileNameAndPath = Paths.get(uploadDirectory, filename);
       try {
           Files.write(fileNameAndPath, file.getBytes());
       } catch (IOException e) {
           e.printStackTrace();
       }

       // UsersModel authenticated=usersService.authenticate(usersModel.getLogin(), usersModel.getPassword());
       AddPostModel addedPost = usersService.addPost(uid1, filename, addPostModel.getCaption(), addPostModel.getLocatn());
       return addedPost == null ? "error_page1" : "success_page_posts";
     /*  if(addedPost!=null){
           model.addAttribute("userLogin",authenticated.getId());
           return "personal_page";
       } else {
           return "/error_page1";
       }*/


   }



    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel){
        System.out.println("register request: "+usersModel);
        UsersModel registeredUser=usersService.registerUser(usersModel.getLogin(), usersModel.getPassword(),usersModel.getEmail());
        return registeredUser==null ? "/error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel,Model model){
        System.out.println("login request: "+ usersModel);
        UsersModel authenticated=usersService.authenticate(usersModel.getLogin(), usersModel.getPassword());
        if(authenticated!=null){
            model.addAttribute("userLogin",authenticated.getLogin());
            uid1= authenticated.getId();

        return "feed_page";
        } else {
            return "/error_page";
        }
    }

    @PostMapping("/journal")
    public String journal(@ModelAttribute JournalModel journalModel){
        JournalModel addedJournal=usersService.addJournal(uid1, journalModel.getJtitle(), journalModel.getText(), journalModel.getLocatn());
        return addedJournal==null ? "/error_page" : "success_page";
    }
    @PostMapping("/start_trip")
    public String start_trip(@ModelAttribute StartTripModel startTripModel,@RequestParam("start12_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date start12_date,@RequestParam("end12_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end12_date)

        {
        System.out.println("trip request: "+startTripModel);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-mm-dd");
        String strstartDate = dateFormat.format(start12_date);
        String strendDate = dateFormat1.format(end12_date);
        StartTripModel addedTrip=usersService.addTrip(uid1,startTripModel.getLocations(),strstartDate,strendDate,startTripModel.getHotelname(),startTripModel.getTravelmode(),startTripModel.getFriends());
        return addedTrip==null ? "/error_page2" :  "success_page_trip";
    }
    @PostMapping("/displayTrips")
    public String displayTrips(@ModelAttribute StartTripModel startTripModel,Model model) {
        List<StartTripModel> retrievedrecs = usersService.retrieveTripRecords();
        if (retrievedrecs != null) {
            model.addAttribute("retrieveTrips", retrievedrecs);
            return "display_trips";
        }
    return "/error_page2";
    }
    @PostMapping("/displayJournals")
    public String displayJournals(@ModelAttribute JournalModel journalModel,Model model) {
        List<JournalModel> retrievedrecs1 = usersService.retrieveJournalRecords();
        if (retrievedrecs1 != null) {
            model.addAttribute("retrieveJournals", retrievedrecs1);
            return "display_journals";
        }
        return "/error_page2";
    }
    @PostMapping("/displayPosts")
    public String displayPosts(@ModelAttribute AddPostModel addPostModel,Model model) {
        List<AddPostModel> retrievedrecs2 = usersService.retrievePostRecords();
        if (retrievedrecs2 != null) {
            model.addAttribute("retrieveJournals", retrievedrecs2);
            return "display_posts";
        }
        return "/error_page2";
    }

}