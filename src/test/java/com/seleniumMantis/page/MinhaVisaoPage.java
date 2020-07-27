package com.seleniumMantis.page;

import com.seleniumMantis.bases.PageBase;
import org.openqa.selenium.By;

public class MinhaVisaoPage extends PageBase
{
        By menuMinhaVisao = By.xpath("//a[@href= '/mantis/my_view_page.php']");

        public void abrirMenuMinhaVisao()
        {
            click(menuMinhaVisao);
        }

        public boolean verificaExistenciaTarefaMinhaVisao(String codTarefa)
        {
            By campoTarefa = By.xpath("//td[@class = 'nowrap width-13 my-buglist-id']/a[contains(@href,'/mantis/view.php') and text() = '"+ codTarefa + "' ]");
            return returnIfElementsAreDisplayed(campoTarefa);
        }

}
