package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.CardSinglesRepository;
import com.example.demo.repositories.CardSleevesRepository;
import com.example.demo.repositories.BoosterPacksRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.tree.AbstractLayoutCache;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final CardSinglesRepository partRepository;
    private final BoosterPacksRepository productRepository;

    private final CardSleevesRepository outsourcedPartRepository;

    public BootStrapData(CardSinglesRepository partRepository, BoosterPacksRepository boosterPacksRepository, CardSleevesRepository cardSleevesRepository) {
        this.partRepository = partRepository;
        this.productRepository = boosterPacksRepository;
        this.outsourcedPartRepository= cardSleevesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(partRepository.count() == 0)
        {

            //creating new parts
            InhousePart queensdiamond = new InhousePart();
            queensdiamond.setName("Queen's Diamond");
            queensdiamond.setInv(17);
            queensdiamond.setPrice(5.00);
            queensdiamond.setId(1);
            partRepository.save(queensdiamond);

            InhousePart lupismaxim = new InhousePart();
            lupismaxim.setName("Lupis Maxim");
            lupismaxim.setPrice(3.75);
            lupismaxim.setInv(26);
            lupismaxim.setId(2);
            partRepository.save(lupismaxim);

            InhousePart pharoahsdraw = new InhousePart();
            pharoahsdraw.setId(3);
            pharoahsdraw.setName("Pharoah's Draw");
            pharoahsdraw.setPrice(8.56);
            pharoahsdraw.setInv(42);
            partRepository.save(pharoahsdraw);

            InhousePart monstergraveyard = new InhousePart();
            monstergraveyard.setName("Monster Graveyard");
            monstergraveyard.setInv(11);
            monstergraveyard.setId(4);
            monstergraveyard.setPrice(2.75);
            partRepository.save(monstergraveyard);

            InhousePart tombofsuccumbing = new InhousePart();
            tombofsuccumbing.setName("Tomb of Succumbing");
            tombofsuccumbing.setPrice(5.65);
            tombofsuccumbing.setId(5);
            tombofsuccumbing.setInv(21);
            partRepository.save(tombofsuccumbing);



       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */
            if(productRepository.count() == 0)
            {
            Product rallyhere = new Product();
            rallyhere.setName("Rally Here Booster Pack");
            rallyhere.setInv(45);
            rallyhere.setPrice(10.00);
            rallyhere.setId(6);
            productRepository.save(rallyhere);

            Product blingedout = new Product();
            blingedout.setName("Blinged Out Booster Pack");
            blingedout.setId(7);
            blingedout.setPrice(11.00);
            blingedout.setInv(56);
            productRepository.save(blingedout);

            Product egyptian = new Product();
            egyptian.setName("Egyptian Pharaoh Booster Pack");
            egyptian.setInv(71);
            egyptian.setId(8);
            egyptian.setPrice(10.00);
            productRepository.save(egyptian);

            Product blazingice = new Product();
            blazingice.setPrice(15.00);
            blazingice.setName("Blazing Ice Booster Pack");
            blazingice.setId(9);
            blazingice.setInv(31);
            productRepository.save(blazingice);

            Product constructionabduction = new Product();
            constructionabduction.setName("Construction Abduction Booster Pack");
            constructionabduction.setPrice(9.00);
            constructionabduction.setId(10);
            constructionabduction.setInv(64);
            productRepository.save(constructionabduction);

            }
            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());


    }
}
