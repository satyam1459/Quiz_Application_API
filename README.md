# Quiz Application
This repository contains the code for a Quiz Application API that allows users to practice quiz and admin to add question , update questions, delete questions and also prepare quiz for users on a specific topic.

>### Prerequisites
* ![MySql](https://img.shields.io/badge/DBMS-MYSQL%205.7%20or%20Higher-red)
 * ![SpringBoot](https://img.shields.io/badge/Framework-SpringBoot-green)


* ![Java](https://img.shields.io/badge/Language-Java%208%20or%20higher-yellow)

>## Data flow
 The application is built using the SpringBoot framework and consists of four layers: Payloads, model, service, and repository.-

* **Payloads** -The Payload layer consists of classes that are used to show whatever limited data we want to show user.
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the h2-database thing on which CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.

## API Definition

### Question Controller

**PUT /api/question/{id}**
- Update a question by its ID.

**DELETE /api/question/{id}**
- Delete a question by its ID.

**GET /api/questions**
- Retrieve all questions.

**POST /api/questions**
- Create a new question.

**GET /api/questions/category/{category}**
- Retrieve questions based on a specific category.

### Quiz Controller

**POST /quiz**
- Start a new quiz.

**POST /quiz/submit/{id}**
- Submit a quiz with the specified ID.

**GET /quiz/{id}**
- Retrieve the details of a completed quiz by its ID.

## Schemas

**Question**
- This schema represents a question in the quiz application.
```
{
    id: [...],
    questionTitle: [...],
    option1: [...],
    option2: [...],
    option3: [...],
    option4: [...],
    correctAnswer: [...],
    difficultyLevel: [...],
    category: [...]
}
```

**Response**
- This schema represents the response format for submitting a quiz.
```
{
    id: [...],
    response: [...]
}
```

**QuestionWrapper**
- This schema represents a simplified version of the question for display purposes.
```
{
    id: [...],
    questionTitle: [...],
    option1: [...],
    option2: [...],
    option3: [...],
    option4: [...]
}
```

## How to Use the Quiz Application API

1. Make sure you have the quiz application server running on `http://localhost:8080`.

2. Interact with the Quiz API using the provided endpoints and schemas.

3. Use HTTP methods such as GET, POST, PUT, and DELETE to interact with the API.

4. To create, update, or delete a question, use the respective endpoints in the Question Controller.

5. To retrieve all questions or questions of a specific category, use the appropriate endpoints in the Question Controller.

6. To start a new quiz, use the `/quiz` endpoint with the POST method.

7. To submit a completed quiz, use the `/quiz/submit/{id}` endpoint with the POST method, providing the quiz ID in the URL.

8. To retrieve the details of a completed quiz, use the `/quiz/{id}` endpoint with the GET method, providing the quiz ID in the URL.

## Note

Ensure that you provide valid data in the request payloads as per the defined schemas for creating or updating questions and submitting quiz responses.

Always handle errors gracefully and validate the data to maintain the integrity and security of the quiz application.

Feel free to explore and experiment with the API to build exciting quiz applications or integrate it into existing projects.

Happy quizzing! 🎉
