package com.example.controller;

import com.example.model.CatCard;
import com.example.dao.CatCardDao;
import com.example.model.CatFact;
import com.example.model.CatPic;
import com.example.services.CatFactService;
import com.example.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CatController {

    private CatCardDao cat;
    private CatFactService catFact;
    private CatPicService catPic;

    public CatController(CatCardDao cat, CatFactService catFact, CatPicService catPic) {
        this.cat = cat;
        this.catFact = catFact;
        this.catPic = catPic;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CatCard getIndividualCard(@PathVariable long id) {
        CatCard card = cat.get(id);
        if (card == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CatCard not found");
        }
        return cat.get(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CatCard> getAllCards() {

        return cat.list();  //Need to fix this.
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public CatCard makeNewCard() {
        CatFact f = catFact.getFact();
        CatPic p = catPic.getPic();
        CatCard c = new CatCard();
        c.setCatFact(f.getText());
        c.setImgUrl(p.getFile());
        //c.              Need to fix this.
        //c.              Need to fix this.
        return c;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void saveNewCard(@Valid @RequestBody CatCard incomingCard) {
        //cat.   Need to fix this
        cat.save(incomingCard);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateExistingCard(@Valid @RequestBody CatCard changedCard, @PathVariable long id) {
       //cat.     Need to fix this
        cat.update(id,changedCard);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteExistingCard(@PathVariable long id) {
        //cat     Need to fix this.
        cat.delete(id);
    }
}
