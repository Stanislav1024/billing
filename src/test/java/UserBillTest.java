
import com.programmer.gate.Application;
import com.programmer.gate.model.UserBill;
import com.programmer.gate.service.UserBillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserBillTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserBillService userBillService;

    /**
     * Тестирование стартовой страницы
     */
    @Test
    public void testGreeting() throws Exception {

        mvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }

    /**
     * Тестирование регистрации 50 пользователей
     */
    @Test
    public void testRegistration() throws Exception {

        List<UserBill> userBillList = new ArrayList<>();

        for(int i = 0; i < 50; i++){

            userBillList.add(userBillService.save(createUserBill()));
        }

        assertEquals(50, userBillList.size());
    }

    /**
     * Создание тестового счета пользователя
     * @return тестовый счет пользователя
     */
    private UserBill createUserBill(){

        //Создание произвольной даты рождения
        Date birthday = new Date();
        Random random = new Random();
        long time = birthday.getTime() - 52560000000L + random.nextInt(1000000000);
        birthday = new Date(time);

        System.out.println(birthday);

        UserBill userBill = new UserBill();

        userBill.setBirthday(birthday);
        userBill.setSurname("Иванов");
        userBill.setSurname("Иван");
        userBill.setSurname("Иванович");

        //Создание произвольного счета
        double bill = random.nextInt(1000000) / 1000;
        userBill.setBill(bill);

        return userBill;
    }

    /**
     * Тестирование зачисления/списания на счета пользователей в 10 потоках
     */
    @Test
    public void testBillChanging() throws Exception {

        List<UserBill> userBillList = new ArrayList<>();
        List<UserBill> allUserBillList = new ArrayList<>();
        List<UserBill> modifiedUserBillList = new ArrayList<>();
        Iterable<UserBill> allUserBills = userBillService.findAll();
        allUserBills.forEach(allUserBillList::add);

        //Создание 10 объектов
        for(int i = 0; i < 10; i++){

            userBillList.add(allUserBillList.get(0));
        }

        //Обработка 10 объектов в отдельных потоках, т.е. получается 10 потоков
        userBillList.parallelStream().forEach(userBill -> {
            userBill = changeUserBill(userBill);
            modifiedUserBillList.add(userBillService.save(userBill));
        });

        assertNotSame(modifiedUserBillList, userBillList);
    }

    /**
     * Изменение счета пользователя
     * @return тестовый счет пользователя
     */
    private UserBill changeUserBill(UserBill userBill){

        double bill= userBill.getBill();
        Random random = new Random();
        bill = bill + random.nextInt(2000) - 1000;//Начисление и списание
        userBill.setBill(bill);

        return userBill;
    }
}
