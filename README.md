# Url shortener

### endpoints

#### 
    /url:
        summary: "Create short link"
            post:
                RequestBody:
                    url: String, required
####
    /{hash}
        summary: "Get origin link"
            get: 
                RequestParams:
                    hash: String

### Implementation details

####
    - Layered architecture (Controller-Service-Repository-Domain)
    - No Mappers to map DTOs and entity objects
    - TODO: logging, infromative log records
    - h2 in memory DB for tests (simple and fast)
    - Speaking of hash - it is now cut to 8 chars, so there we are limited with amount of links before collision
            to solve this, we could have used users ID as a part of short link for example
    - Config added per environment[DEV-STAGING-PROD], 
        it is implemented as if we had secrets stored in AWS secrets manager for example
    - Since the flow is not complicated at the moment, 
        the API can consume requests while it has available connections in the pool. Same works for the DB. 
    - TODO: add more/update scenarious in tests
    - TODO: added expiration date which is not used for now
