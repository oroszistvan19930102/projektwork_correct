## Digital Bank – User Stories ##

---

## User Story 1 – Bejelentkezés

*Mint regisztrált felhasználó
Szeretnék bejelentkezni az alkalmazásba
Hogy hozzáférhessek a személyes tartalmakhoz és funkciókhoz*

### Elfogadási kritériumok:
- A felhasználó megnyitja a bejelentkezési oldalt
- A felhasználó sikeresen be tud jelentkezni érvényes adatokkal
- Hibás adatok esetén a rendszer megfelelő hibaüzenetet jelenít meg

---

## User Story 2 – Folyószámla létrehozása

*Mint regisztrált felhasználó
Szeretnék létrehozni egy új folyószámla profilt
Hogy kezelhessem a pénzügyeimet az alkalmazásban*

### Elfogadási kritériumok:
- A felhasználó bejelentkezik az alkalmazásba
- A felhasználó navigál a folyószámla létrehozási oldalra
- A felhasználó megadja a szükséges adatokat (pl. számlatípus, tulajdonos, számlanév, kezdő egyenleg)
- Hibás vagy hiányos adatok esetén a rendszer megfelelő hibaüzenetet jelenít meg
- Sikeres mentés esetén a rendszer megerősítő üzenetet jelenít meg és megjeleníti a meglévő folyószámlák listáját

---

## User Story 3 – Megtakarítás létrehozása
*Regisztrált felhasználóként létre tudok hozni megtakarítási folyószámla profilt.*

### Elfogadási kritériumok:
- A bejelentkezés után a dashboard oldal bal oldali menüjéből kiválasztom a **Savings** lehetőséget
- A legördülő menüből kiválasztom a **New Savings** lehetőséget
- Megjelenik a **Create savings** oldal
- **Savings Account Type** és **Account Ownership** kiválasztása után megadok egy **Account Name** és **Deposit Amount** értéket
- Ha a deposit amount nem ér el egy minimális értéket, hibaüzenetet kapok
- Helyes mentés esetén a **View savings accounts** oldal tölt be a meglévő megtakarítási folyószámlák listájával és megerősítő üzenettel
- Létrejött az új megtakarítási folyószámla

---

## User Story 4 – Utalás folyószámlára
*Regisztrált felhasználóként utalni tudok pénzösszeget egy meglévő számlára.*

### Elfogadási kritériumok:
- A bejelentkezés után a dashboard oldal bal oldali menüjéből kiválasztom a **Deposit** lehetőséget
- Megjelenik a **Deposit** oldal
- A legördülő menüből kiválasztom, melyik számlára szeretném utalni az összeget
- A **Deposit Amount** alatt megadom az összeget
- Üres **Deposit Amount** esetén figyelmeztető üzenet jelenik meg
- Helyes adatok esetén a **View checking accounts** oldal tölt be
- A **Transactions** lista legfelső eleme a legutóbbi tranzakciót mutatja

---

## User Story 5 – Levétel folyószámláról
*Regisztrált felhasználóként pénzösszeget tudok levonni egy meglévő számláról.*

### Elfogadási kritériumok:
- A bejelentkezés után a dashboard oldal bal oldali menüjéből kiválasztom a **Withdraw** lehetőséget
- Megjelenik a **Withdraw** oldal
- A legördülő menüből kiválasztom, melyik számláról szeretném levonni az összeget
- A **Withdraw Amount** alatt megadom az összeget
- Ha a levonni kívánt összeg nagyobb, mint a folyószámlán található összeg → hibaüzenet
- Helyes adatok esetén a **View checking accounts** oldal tölt be
- A **Transactions** lista legfelső eleme a legutóbbi tranzakciót mutatja

---

## User Story 6 – Folyószámlák közötti tranzakció
*Regisztrált felhasználóként a meglévő folyószámláim között tudok összeget mozgatni.*

### Elfogadási kritériumok:
- A bejelentkezés után a dashboard oldal bal oldali menüjéből kiválasztom a **Transfer Between Accounts** lehetőséget
- Megjelenik az **Internal Transfer** oldal
- A két legördülő menüből kiválasztom a forrás- és célszámlát
- A **Transfer Amount** értékhez megadom az összeget
- Ha a mozgatni kívánt összeg nagyobb, mint a forrásszámlán levő egyenleg → hibaüzenet
- Ha a forrás- és célszámla ugyanaz → hibaüzenet
- Helyes adatok esetén a **View checking accounts** oldal tölt be
- A **Transactions** lista legfelső eleme a legutóbbi tranzakciót mutatja

---

## User Story 7 – Minden tranzakciós és folyószámlaadat törlése
*Regisztrált felhasználóként törölni tudok minden tranzakciós és folyószámlaadatot.*

### Elfogadási kritériumok:
- A jobb felső profil ikon alól kiválasztom a **Delete data** lehetőséget
- Minden folyószámla és tranzakciós adat törlődik