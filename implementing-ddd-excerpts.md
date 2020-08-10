## 1. Getting Started With DDD

  ### Anemia and Memory Loss

  [Anemic Domain Model](https://www.martinfowler.com/bliki/AnemicDomainModel.html) was a term coined by Martin Fowler to indicate the lack of behaviour in the domain objects and is generally deemed as an anti-pattern.

  Two questions to ask to see if your model is anemic:

    1. Does the objects mostly have only public getters and setters in the name of behaviour, and are mostly data holding objects?

    2. Are softwares component that use your domain model the ones which house most of your business logic? And do they heavily invoke the public getters and setters of your domain model? This layer is probably called as *Service Layer* or *Application Layer*

  If **No** is the answer for both of the questions, your domain model is doing pretty well.

  If **Yes** is the answer for both of them, your domain model is anemic.

  Any other case will be a case of denial and you need to re-examine the domain model.

  An **Anemic Model** is a bad thing, because you pay most of the high cost of developing a model and yet, you get very little benefits from it.

  ### How to do DDD

  Two of the most important concepts in DDD are **[Bounded Context](https://martinfowler.com/bliki/BoundedContext.html)** and **[Ubiquitous Language](https://martinfowler.com/bliki/UbiquitousLanguage.html)**, and one cannot properly stand without the other.
  The terms in the ubiquitous language have a specific contextual meaning within a bounded context.

  One of the key points to keep in mind while designing the model is that the model should support every single one of the possible business goals. The business model appears from a continuous discussions and modifications. Also, application services should also reflect the explicit intention of the business goals at hand. Every application service method should deal with a single use case or user story.

  ### Business Value of DDD

  Really, this section should've been named "How to sell DDD to your boss". The main advantages of using DDD are:
  1. The Organization Gains a Useful Model of its Domain
  2. A Refined, Precise Definition And Understanding of Business is Developed
  3. Domain Experts Contribute to Software Design
  4. A Better User Experience is Gained


### Challenges of Applying DDD

  * Allowing for the time and the effort required to create a Ubiquitous Language
  * Involving domain experts at the outset and continuously with the project
  * Changing the way developers think about solutions in their Domain: Developing the Ubiquitous Language for your domain is the best place to start

  Questions that'll help in deciding whether to go with DDD or not:
  1. Are domain experts available and are you committed to forming teams around them?
  2. Although the specific business domain is somewhat simple now, will it grow in complexity over time? If you use [Transaction Script](https://martinfowler.com/eaaCatalog/transactionScript.html) now, will the potential for refactoring to a behavioural domain model later on be practical if domain becomes complex?
  3. Will the user of DDD tactical patterns(Aggregates/Services/Value Objects etc) make it easier to integrate with other Bounded Contexts?
  4. Do the critical path and timeline allow for allow for any overhead required for tactical investment?
  5. Will the tactical investment in a Core domain protect it from changing architectural influences?

### DDD is not Heavy




## 2. Domains, Subdomains and Bounded Contexts
