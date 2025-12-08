## Digital Bank user stories ##
#####################################################UserStory-1########################################################
US1: Bejelentkezés
Regisztrált felhasználóként szeretnék sikeresen bejelentkezni érvényes email cím és jelszó megadásával

Elfogadási kritériumok:
A rendszer megjeleníti a bejelentkezési oldalt
Érvényes felhasználónevet és jelszót adok meg
Bejelentkezem.
A rendszer a dashboard oldalra navigál.
Hibás adatok esetén megfelelő hibaüzenet jelenik meg.
#####################################################UserStory-2########################################################
US2: Folyószámla létrehozása
Regisztrált felhasználóként létre tudok hozni folyószámla profilt. 

Elfogadási kritériumok:
A bejelentkezés után a dashboard oldal bal oldali menüjéből kiválasztom a Checking lehetőséget
A legördülő menüből kiválasztom a New Checking lehetőséget.
Megjelenik a Create checking oldal.
Checking Account Type és Account Ownership kiválasztása után megadok egy account name és deposit amount értéket.
Ha a deposit amount nem ér el egy minimális értéket, hibaüzenetet kapok.
Helyes mentés kesetén a View checking accounts oldal töltődik be a meglévő folyószámlák listájával és egy megerősítő üzenettel.
Létrejött az új folyószámla.
#####################################################UserStory-3########################################################
US3: Megtakarítás létrehozása
Regisztrált felhasználóként létre tudok hozni megtakarítási folyószámla profilt.

Elfogadási kritériumok:
A bejelentkezés után a dashboard oldal bal oldali menüjéből kiválasztom a Savings lehetőséget
A legördülő menüből kiválasztom a New Savings lehetőséget.
Megjelenik a Create savings oldal.
Savings Account Type és Account Ownership kiválasztása után megadok egy account name és deposit amount értéket.
Ha a deposit amount nem ér el egy minimális értéket, hibaüzenetet kapok.
Helyes mentés kesetén a View savings accounts oldal töltődik be a meglévő megtakarítási folyószámlák listájával és egy megerősítő üzenettel.
Létrejött az új megtakarítási folyószámla.
#####################################################UserStory-4########################################################
US4: Utalás folyószámlára
Regisztrált felhasználóként utalni tudok pénzösszeget egy meglévő számlára

Elfogadási kritériumok:
A bejelentkezés után a dashboard oldal bal oldali menüjéből kiválasztom a Deposit lehetőséget
Megjelenik a Deposit oldal
A legördülő menüből kiválasztom melyik számlára szeretném utalni az összeget.
A deposit amount alatt megadom az összeget.
Üresen hagyott deposit amount esetén figyelmeztető üzenet jelenik meg
Helyes adatok esetén a view checking accounts oldal tölt be.
A Transactions lista legfelső eleme a legutóbbi tranzakciót mutatja
#####################################################UserStory-5########################################################
US5: Levétel folyószámláról
Regisztrált felhasználóként pénzösszeget tudok levonni egy meglévő számláról

Elfogadási kritériumok:
A bejelentkezés után a dashboard oldal bal oldali menüjéből kiválasztom a Withdraw lehetőséget
Megjelenik a Withdraw oldal
A legördülő menüből kiválasztom melyik számláról szeretném levonni az összeget.
A withdraw amount alatt megadom az összeget.
Ha a levonni kívánt összeg nagyobb mint a folyószámlán található összeg, akkor hibaüzenetet kapok.
Helyes adatok esetén a view checking accounts oldal tölt be.
A Transactions lista legfelső eleme a legutóbbi tranzakciót mutatja
#####################################################UserStory-6########################################################
US6: Folyószámlák közötti tranzakció
Regisztrált felhasználóként a meglévő folyószámláim között tudok összeget mozgatni.

Elfogadási kritériumok:
A bejelentkezés után a dashboard oldal bal oldali menüjéből kiválasztom a Transfer Between Accounts lehetőséget
Megjelenik az Internal Transfer oldal
A két legördülő menüből kiválasztom a forrászszámlát és a célszámlát.
A transfer amount értékhez az átmozgatni kívánt összeget adom meg.
Ha a mozgatni kívánt összeg nagyobb mint a forrásszámlán található összeg, akkor hibaüzenetet kapok.
Ha a forrás- és célszámla ugyanaz, hibaüzenetet kapok.
Helyes adatok esetén a view checking accounts oldal tölt be.
A Transactions lista legfelső eleme a legutóbbi tranzakciót mutatja
#####################################################UserStory-7########################################################
US7: Minden tranzakciós és folyószámlaadat törlése
Regisztrált felhasználóként töröölni tudok minden tranzakciós és folyószámlaadatot

Elfogadási kritériumok:
A jobb felső profil ikon alól kiválasztom a Delete data lehetőséget
Minden folyószámla és tranzakciós adat törlődik.
