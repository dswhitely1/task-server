# Task Database written in Java

## This Database was written to go with the Reducer Todo application from Lambda School.

### Table

| taskid | task | completed | date |
|--------|------|-----------|------|
| long | String | Boolean | LocalDate |

#### Get All Tasks
```json
GET /api/tasks
```
Returns all tasks

#### Get Single Task
```json
GET /api/task/:id
```
Returns Task based on the ID passed in

#### POST Task
```json
POST /api/task
```

On Success, returns all Tasks

#### PUT Task
```json
PUT /api/task/:id
```

On Success, returns all Tasks
#### DELETE Task
```json
DELETE /api/task/:id
```
On Success, returns all remaining Tasks