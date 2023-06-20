# Hitman RESTful Service

### CRUD Methods
#### Hitman ("/api/hitman"):
- **GET** (endpoint: "/getHitmanById/{id}")
- **GET** (endpoint: "/getAllHitmans")
- **DELETE** (endpoint: "/deleteHitman/{id}")
- **PUT** (endpoin: "/editHitman")
- **POST** (endpoin: "/createHitman"):

**Post/Put Hitman Body Example:**
```
    {
        "id": 1,
        "hitmanName": "John Wick",
        "hitmanContry": "New York",
        "hitmanAge": 33,
        "hitmanWeapon": "M4A1",
        "hitmanExcommunicado": 1
    }
```

#### Weapon ("/api/weapon"):
- **GET** (endpoint: "/getWeaponById/{id}")
- **GET** (endpoint: "/getAllWeapons")
- **DELETE** (endpoint: "/deleteWeaponById")
- **PUT** (endpoin: "/editWeapon")
- **POST** (endpoint: "/createWeapon"):

**Post/Put Weapon Body Example:**
```
    {
        "id": 1,
        "weaponName": "M4A1",
        "weaponQuantity": 3,
        "hitmanLinkId": 2
    }
```


### Database Diagram:
![image](https://github.com/neblessed/hitman_rest_api/assets/110935510/cf747cec-9a28-45a5-9319-8308f5dab270)

