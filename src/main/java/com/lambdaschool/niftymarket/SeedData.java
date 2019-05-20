package com.lambdaschool.niftymarket;


import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.Role;
import com.lambdaschool.niftymarket.model.User;
import com.lambdaschool.niftymarket.model.UserRoles;
import com.lambdaschool.niftymarket.repos.CardRepository;
import com.lambdaschool.niftymarket.repos.RoleRepository;
import com.lambdaschool.niftymarket.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;

    CardRepository cardRepository;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, CardRepository cardRepository)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;

        this.cardRepository = cardRepository;
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




        Card c1 = new Card("Daragaz the Ignitor","Dragon Legend","https://6d4be195623157e28848-7697ece4918e0a73861de0eb37d08968.ssl.cf1.rackcdn.com/162131_200w.jpg",1999.00);
        Card c2 = new Card("SpiritMonger", "Soul eater", "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=438775&type=card",2000.00);
        Card c3 = new Card("Royal Assassin","a king's most trusted courier","https://img.scryfall.com/cards/large/en/m12/105.jpg?1517813031",2019.00);
        Card c4 = new Card("Tefaris Moat", "Enchantment", "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=108787&type=card",1000.00);




        cardRepository.save(c1);
        cardRepository.save(c2);
        cardRepository.save(c3);
        cardRepository.save(c4);
    }
}
