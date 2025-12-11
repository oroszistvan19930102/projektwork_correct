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

## User Story 2 – Számla létrehozása

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

## User Story 3 – Utalás folyószámlára

*Mint regisztrált felhasználó
Szeretnék pénzt befizetni egy meglévő folyószámlára
Hogy növelhessem annak egyenlegét és kezelhessem a pénzügyeimet az alkalmazásban*

### Elfogadási kritériumok:
- A felhasználó bejelentkezik az alkalmazásba
- A felhasználó navigál a befizetési funkcióhoz
- A felhasználó kiválasztja a befizetési számlát és megadja a befizetendő összeget
- Hibás, hiányos vagy nem megfelelő összeg esetén a rendszer megfelelő hibaüzenetet jelenít meg
- Sikeres tranzakció esetén a rendszer megerősítő üzenetet jelenít meg és frissíti a kiválasztott számla tranzakciós listáját

---

## User Story 4 – Levétel folyószámláról

*Mint regisztrált felhasználó
Szeretnék pénzt levonni egy meglévő folyószámláról
Hogy kezelhessem a számla egyenlegét az alkalmazásban*

### Elfogadási kritériumok:
- A felhasználó bejelentkezik az alkalmazásba
- A felhasználó navigál a levonási funkcióhoz
- A felhasználó kiválasztja a számlát és megadja a levonni kívánt összeget
- Hibás, hiányos vagy a számla egyenlegét meghaladó összeg esetén a rendszer megfelelő hibaüzenetet jelenít meg
- Sikeres tranzakció esetén a rendszer megerősítő üzenetet jelenít meg és frissíti a kiválasztott számla tranzakciós listáját

---

## User Story 5 – Folyószámlák közötti tranzakció

*Mint regisztrált felhasználó
Szeretnék összeget átutalni a saját folyószámláim között
Hogy egyszerűen kezelhessem pénzügyeimet az alkalmazásban*

### Elfogadási kritériumok:
- A felhasználó bejelentkezik az alkalmazásba
- A felhasználó navigál a belső átutalási funkcióhoz
- A felhasználó kiválasztja a forrás- és célszámlát, és megadja az átutalandó összeget
- Hibás, hiányos, a forrás számla egyenlegét meghaladó összeg vagy azonos forrás- és célszámla esetén a rendszer megfelelő hibaüzenetet jelenít meg
- Sikeres tranzakció esetén a rendszer megerősítő üzenetet jelenít meg és frissíti a tranzakciós listát a legutóbbi átutalással

---
