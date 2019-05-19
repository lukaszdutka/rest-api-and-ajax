w folderze: rsi/src/main/
    znajdują się pliki związane zarówno z frontendem i backendem aplikacji.

    Jest to uproszczenie, ponieważ folder 'frontend' jest uruchamiany na
    osobnym serwerze - npm wykorzystujący node.js i prosty jQuery/javascript/html

folder: frontend zawiera cały frontend,
    natomiast interesujące nas pliki są w folderze 'webdir' - html, js (w nim ajax) i css


folder: 'java' zawiera w sobie całykod javowy.
    po wejściu wgłąb aż w folder 'crud' znajduje się:
        folder "controller":
            zawierający definicję wszystkich metod wymaganych do działania CRUDa
        folder dto:
            definicję obiektu przesyłanego
        folder repository:
            obsługę "bazy danych" opartej o listę elementów

    Natomiast w folderze po prostu "crud", tam gdzie znajdują się w/w foldery jest klasa
    o nazwie "Application", która zawiera kod uruchamiający aplikację.