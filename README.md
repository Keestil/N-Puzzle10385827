N-Puzzle10385827
================

tweede app

De volgende classes ga ik maken, en in het plaatje zie je welke subclasses zijn en welke hoofd:

-MainMenu
-StartGame
-Choose_image
-Show_solution
-Game
-Game_menu
-Reset
-Difficulty
-Choose_difficulty
-Leaderbords
-My_highscores
-highscore_Images
-World_highscores
-World_highscore_images

1) Hoe gaan we van scherm naar scherm?

Hiervoor zullen we de setOnClicklistener gebruiken, waarbij we elke schermpje waarschijnlijk een ID zullen toekennen om 
Copy-pasten gemakkelijker te maken.

2) Hoe gaam we het spel maken

- Ten eerste zullen we met behulp van Imageview een database maken met 3 plaatjes. En met behulp van imageLoader 
Plaatjes kunnen uploaden, waarbij we het liefst de drempel van 2 zouden willen toepassen.

- Ten tweede gaan we deze plaatjes hakken in een 3x3, 6x6 of 9x9 matrix. Eerst zullen we de plaatjes rescalen mbv
Bitmap.CreateScaledBitmap() en vervolgens hakken we deze in stukjes met Bitmap.CreateBitmap(), na het hakken zou het
mooi zijn als we een method kunnen vinden die de gehakte stukken willekeurig neerlegt. Dit zalk de reset button ook doen
als we het menutje gemaakt hebben. 

- Om het spel goed te laten verlopen zullen we alle tegels een ID nummer geven, en in het bijzonder het ID nummer
van de witte tegel moeten onthouden. Omdat alleen met de witte tegel gewisselt mag worden zullen we de java-code 
zdd moeten maken dat men alleen stappen kan zetten met het IDnummer van de witte tegel en de omringende tegels daarvan.
Als alle ID nummers op de goede plek staan stopt het spel(en de timer) en zal er een gefeliciteerd scherm komen.

- Om alle stappen op te slaan zullen we gebruik maken van SharedPreferences()

3) Hoe houden we highscores bij?

Met behulp van de Timer en de Listview is het mogelijk een database te creeren met namen en tijden. We kunnen deze ook
sorteren met Listsort. Verder zou ik eventueel het aantal stappen erbij kunnen zetten en saven met SharedPreferences.

4)
