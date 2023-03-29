# Project-PAO
Definim un sistem de firme de transport.
In acest sistem avem diferite tipuri de obiecte precum: person, client, driver, company, car, order, location si ordereview precum 
si enumurile Culoare si DriverLicenceCategories, in fiecare din aceste clase implementand diferite metode.
In clasa Person am implementat: extragerea unei persoane dupa id, extragerea tuturor persoanelor, adaugarea unei persoane, modificarea 
unei persoane si stergerea ei
In clasa Client mosteneste clasa Person si am implementat si functionalitatea de a schimba numarul de telefon, si de a schimba emailul.
Clasa Driver de asemenea mosteneste clasa Person si am implementat aceleasi functii ca la Client plus metoda care adauga unui sofer
o noua categorie de permis auto.
In clasa Company, pe langa metodele CRUD, aceleasi ca la Person, am implementat si metodele: adaugarea unui nou sofer la companie,
modificarea numarului de angajati din companie, schimbarea ownerului companiei, schimbarea numelui companiei si sortatea soferilor companiei
in functie de numarul categoriei de licente detinute.
In clasa Car am implementat metodele CRUD si schimbarea culorii masinii.
In clasa Location avem de asemenea motodele CRUD.
In clasa Order avem motodele CRUD si metodele care anuleaza o comanda, schimba locatia comenzii si schimba timpul de livrare al comenzii.
In clasa OrderReview avem implementate metodele CRUD.
