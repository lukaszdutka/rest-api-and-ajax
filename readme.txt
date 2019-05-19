w folderze: src/main/
    znajdują się pliki związane zarówno z frontendem i backendem aplikacji.

    Jest to uproszczenie, ponieważ folder 'frontend' jest uruchamiany na
    osobnym serwerze - npm wykorzystujący node.js i prosty jQuery/javascript/html

folder: frontend zawiera cały frontend,
    natomiast interesujące nas pliki są w folderze 'webdir' - html, js (w nim ajax) i css
    w pliku html mamy całą zapisaną formatkę i odnośniki do funkcji z scripts.js
    scripts.js zawiera funkcje, w których używany jest ajax, wypełniana jest tabela ze
    studentami, wypełniane rowy itd.

folder: 'java' zawiera w sobie całykod javowy.
    po wejściu wgłąb aż w folder 'crud' znajduje się:
        folder "controller":
            zawierający definicję wszystkich metod wymaganych do działania CRUDa
            adnotacja @RequestMapping definiuje ścieżkę do endpointów
            adnotacja @CrossOrigin ogranicza z jakich miejsc można dostać się do API
        folder dto:
            definicję obiektu przesyłanego (zwykły obiekt)
        folder repository:
            obsługę "bazy danych" opartej o listę elementów, podstawowe operacje CRUD
            czyli: stworzyć, przeczytać, zaaktualizować i usunąć element

    Natomiast w folderze po prostu "crud", tam gdzie znajdują się w/w foldery jest klasa
    o nazwie "Application", która zawiera kod uruchamiający aplikację.