package com.lambdaschool.niftymarket;


import com.lambdaschool.niftymarket.model.*;
import com.lambdaschool.niftymarket.repos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;
    VideoGameRepository videoGameRepository;

    CardRepository cardRepository;
    WishListRepository wishListRepository;
//    PurchaseRepository purchaseRepository;
    TransactionRepository transactionRepository;

    GameItemRepository gameItemRepository;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, CardRepository cardRepository, VideoGameRepository videoGameRepository,WishListRepository wishListRepository, TransactionRepository transactionRepository,GameItemRepository gameItemRepository)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.videoGameRepository = videoGameRepository;
        this.cardRepository = cardRepository;
        this.wishListRepository = wishListRepository;
        this.transactionRepository = transactionRepository;
        this.gameItemRepository = gameItemRepository;
//        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = rolerepos.save(r1);
        r2 = rolerepos.save(r2);
        r3 = rolerepos.save(r3);

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> data = new ArrayList<>();
        data.add(new UserRoles(new User(), r2));
        data.add(new UserRoles(new User(), r3));


        User u1 = new User("barnbarn", "ILuvM4th!", users);

        User u2 = new User("admin", "password", admins);

        User u3 = new User("cinnamon", "123456", data);



        userrepos.save(u1);
        userrepos.save(u2);
        userrepos.save(u3);




        Card c1 = new Card("card","magic","Daragaz the Ignitor","Dragon Legend","https://6d4be195623157e28848-7697ece4918e0a73861de0eb37d08968.ssl.cf1.rackcdn.com/162131_200w.jpg",1999.00,u1);
        Card c2 = new Card("card","magic","SpiritMonger", "Soul eater", "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=438775&type=card",2000.00,u1);
        Card c3 = new Card("card","magic","Royal Assassin","a king's most trusted courier","https://img.scryfall.com/cards/large/en/m12/105.jpg?1517813031",2019.00,u2);
        Card c4 = new Card("card","magic","Tefaris Moat", "Enchantment", "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=108787&type=card",1000.00,u3);
        Card c5 = new Card("card","magic","Daragaz the Ignitor","Dragon Legend","https://6d4be195623157e28848-7697ece4918e0a73861de0eb37d08968.ssl.cf1.rackcdn.com/162131_200w.jpg",1999.00,u1);
        Card c6 = new Card("card","magic","SpiritMonger", "Soul eater", "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=438775&type=card",2000.00,u1);
        Card c7 = new Card("card","magic","Royal Assassin","a king's most trusted courier","https://img.scryfall.com/cards/large/en/m12/105.jpg?1517813031",2019.00,u2);
        Card c8 = new Card("card","yugioh","Dark Magician", "Enchantment", "https://images-na.ssl-images-amazon.com/images/I/51nXKpPjg6L.jpg",1000.00,u3);
        Card c9 = new Card("card","yugioh","Exodia","Dragon Legend","https://52f4e29a8321344e30ae-0f55c9129972ac85d6b1f4e703468e6b.ssl.cf2.rackcdn.com/products/pictures/1177157.jpg",1999.00,u1);
        Card c10 = new Card("card","yugioh","Rageki", "Soul eater", "https://usercontent1.hubstatic.com/13110144.png",2000.00,u1);
        Card c11 = new Card("card","pokemon","Charizard","a king's most trusted courier","https://52f4e29a8321344e30ae-0f55c9129972ac85d6b1f4e703468e6b.ssl.cf2.rackcdn.com/products/pictures/1105091.jpg",2019.00,u2);
        Card c12 = new Card("card","pokemon","Squirtle", "Enchantment", "https://52f4e29a8321344e30ae-0f55c9129972ac85d6b1f4e703468e6b.ssl.cf2.rackcdn.com/products/pictures/150203.jpg",1000.00,u3);

        VideoGame v1 = new VideoGame("videogame","RPG","Kingdom Hearts III","RPG","https://images-na.ssl-images-amazon.com/images/I/A109Z6CfX3L._AC_SL1500_.jpg",59.99,u3);
        VideoGame v2 = new VideoGame("videogame","First person shooter","Anthem","RPG","https://images-na.ssl-images-amazon.com/images/I/71yLlOybm3L._AC_SL1000_.jpg",59.99,u3);
        VideoGame v3 = new VideoGame("videogame","RPG","Lego Movie 2","A generic game description. Thrilling, exciting, captivating. All you could ever want!","https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6319/6319218_sd.jpg;maxHeight=640;maxWidth=550",59.99,u3);
        VideoGame v4 = new VideoGame("videogame","Fighting","Mortal Combat 11","RPG","https://images-na.ssl-images-amazon.com/images/I/91V-teXbYGL._AC_SX215_.jpg",59.99,u3);
        VideoGame v5 = new VideoGame("videogame","First person shooter","Red Dead Redemption II","RPG","https://pisces.bbystatic.com/image2/BestBuy_US/images/products/5352/5352400_sd.jpg;maxHeight=640;maxWidth=550",59.99,u2);
        VideoGame v6 = new VideoGame("videogame","RPG","Spider-Man","A generic game description. Thrilling, exciting, captivating. All you could ever want!","https://i.ebayimg.com/images/g/znYAAOSwBGBc3X4D/s-l640.jpg",59.99,u1);
        VideoGame v7 = new VideoGame("videogame","Adventure","Yoshi's Crafted World","A generic game description. Thrilling, exciting, captivating. All you could ever want!","https://pisces.bbystatic.com/image2/BestBuy_US/images/products/5897/5897109_sd.jpg;maxHeight=640;maxWidth=550",59.99,u2);
        VideoGame v8 = new VideoGame("videogame","Adventure","Days Gone","RPG","https://multimedia.bbycastatic.ca/multimedia/products/500x500/104/10439/10439887.jpg",59.99,u1);
        VideoGame v9 = new VideoGame("videogame","First person shooter","Ace Combat","A generic game description. Thrilling, exciting, captivating. All you could ever want!","https://images-na.ssl-images-amazon.com/images/I/81-sHWnURhL._SX342_.jpg",59.99,u2);

        VideoGame v10 = new VideoGame("videogame","RPG","War Groove","A generic game description. Thrilling, exciting, captivating. All you could ever want!","http://images.nintendolife.com/competitions/wargroove_competition/design/0/foreground-image/0/940x.png?v=1548765391",59.99,u3);


        GameItem g1 = new GameItem("gameitem","Runscape","Kingdom Hearts III","Dragon Sword","https://vignette.wikia.nocookie.net/2007scape/images/a/a4/Dragon_sword_detail.png/revision/latest?cb=20170106165110",59.99,u3);
        GameItem g2 = new GameItem("gameitem","World of WarCraft","WW item","RPG","https://i.kinja-img.com/gawker-media/image/upload/s--UIvXbfnd--/c_scale,f_auto,fl_progressive,q_80,w_800/o4nyzxb01lqecya6nvug.jpg",59.99,u3);
        GameItem g3 = new GameItem("gameitem","Guild Wars 2","Guild Wars Account","A generic game description. Thrilling, exciting, captivating. All you could ever want!","https://s1.gaming-cdn.com/images/products/2220/orig/guild-wars-2-path-of-fire-cover.jpg",59.99,u3);
        GameItem g4 = new GameItem("gameitem","Runescape","Crystal Bow","Long Bow","https://thumbnail.imgbin.com/0/23/19/imgbin-runescape-bow-and-arrow-the-elder-scrolls-v-skyrim-recurve-bow-crystal-XTTR7N88adsXWJQPrJRnBF4Ra_t.jpg",59.99,u3);
        GameItem g5 = new GameItem("gameitem","Diablo III","Sword of Justice","Justice weapon","http://www.thinkgeek.com/images/products/zoom/19a7_diablo_3_sword_of_justice_prop_replica.gif",59.99,u2);
        GameItem g6 = new GameItem("gameitem","Runescape","Sword nice","A generic game description. Thrilling, exciting, captivating. All you could ever want!","https://i.ebayimg.com/images/g/znYAAOSwBGBc3X4D/s-l640.jpg",59.99,u1);
        GameItem g7 = new GameItem("gameitem","Guild Wars 2","King's Throne","A generic gameitem description. Thrilling, exciting, captivating. All you could ever want!","https://d3b4yo2b5lbfy.cloudfront.net/wp-content/uploads/2018/08/946f3NoveltiesUI_EN.png",59.99,u2);
        GameItem g8 = new GameItem("gameitem","Diablo III","Diablo Item","RPG","https://multimedia.bbycastatic.ca/multimedia/products/500x500/104/10439/10439887.jpg",59.99,u1);
        GameItem g9 = new GameItem("gameitem","Runescape","Runescape item","A generic game description. Thrilling, exciting, captivating. All you could ever want!","https://vignette.wikia.nocookie.net/runescape2/images/a/af/Sir_Owen_Sonde%27s_shield_detail.png/revision/latest?cb=20130819135740",59.99,u2);


//        ArrayList<Card>mylist = new ArrayList<>();
        Set<Product> a = new HashSet<>();
        a.add(v2);
        a.add(c1);
        WishList sampleWishList = new WishList(a);
        sampleWishList.setUser(u2);
        wishListRepository.save(sampleWishList);

        Transaction t = new Transaction(8888.00,
                "testCard",
                "Test test",
                "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=438775&type=card");

        t.setUser(u2);
        transactionRepository.save(t);


//        mylist.add(c1);
//        mylist.add(c2);
//        mylist.add(c3);
//        ArrayList<VideoGame>mylist2 = new ArrayList<>();
//        mylist2.add(v9);


//        sampleWishList.getMyWishList().add(mylist);
//        sampleWishList.getMyWishList().add(mylist2);

//        System.out.println(sampleWishList.toString());

//        Purchase newpurchase = new Purchase(c2,u2);
//        Purchase newpurchase1 = new Purchase(c1,u2);

//        purchaseRepository.save(newpurchase);
//        purchaseRepository.save(newpurchase1);



        cardRepository.save(c1);
        cardRepository.save(c2);
        cardRepository.save(c3);
        cardRepository.save(c4);
        cardRepository.save(c5);
        cardRepository.save(c6);
        cardRepository.save(c7);
        cardRepository.save(c8);
        cardRepository.save(c9);
        cardRepository.save(c10);
        cardRepository.save(c11);
        cardRepository.save(c12);


        videoGameRepository.save(v1);
        videoGameRepository.save(v2);
        videoGameRepository.save(v3);
        videoGameRepository.save(v4);
        videoGameRepository.save(v5);
        videoGameRepository.save(v6);
        videoGameRepository.save(v7);
        videoGameRepository.save(v8);
        videoGameRepository.save(v9);
        videoGameRepository.save(v10);

        gameItemRepository.save(g1);
        gameItemRepository.save(g2);
        gameItemRepository.save(g3);
        gameItemRepository.save(g4);
        gameItemRepository.save(g5);
        gameItemRepository.save(g6);
        gameItemRepository.save(g7);
        gameItemRepository.save(g8);
        gameItemRepository.save(g9);




//        wishListRepository.save(sampleWishList);

    }
}
