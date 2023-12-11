1. **Users (Clients and Administrators):**
   - **Clients:** Registered users who have access to the application's functionality to manage their finances.
      - **Client ID**
      - Name
      - Surname
      - **Username**
      - Password
      - Email Address
      - **Phone Number**
   - **Administrators:** Users with administrator privileges who can manage the system and handle client requests.
      - **Client ID**
      - Name
      - Surname
      - **Username**
      - Password
      - Email Address
      - **Phone Number**
      - Role - to specify access rights.

2. **Bank Accounts:**
   - **Checking Accounts:** Bank accounts where clients can store funds and perform transactions.
      - **Account ID**
      - **Account Number**
      - Balance
   - **Savings Accounts:** Accounts designed for savings with the possibility of earning interest on them.
      - **Account ID**
      - **Account Number**
      - Balance
      - Interest Rate
   - **Credit Accounts:** Accounts that display information about the client's debt on loans.
      - **Account ID**
      - **Account Number**
      - Debt
      - Interest Rate

3. **Transactions:**
   - **Transfers:** Records of money transfers between client accounts.
      - **Transaction ID**
      - Sender Account
      - Receiver Account
      - Amount
      - Date and Time
   - **Transaction History:** A chronological record of all financial transactions, including transaction details.
      - **Operation ID**
      - Operation Type
      - Account
      - Amount
      - Date and Time

4. **Bank Services and Products:**
   - **Loans:** Various types of loans available to clients with corresponding terms and interest rates.
      - **Loan ID**
      - Loan Type
      - Loan Amount
      - Interest Rate
   - **Deposits:** Various types of deposits with different terms and interest rates.
      - **Deposit ID**
      - Deposit Type
      - Deposit Amount
      - Interest Rate
   - **Installment Plans:** Options for installment payments and payment plans for purchasing goods and services.
      - **Installment Plan ID**
      - Description
      - Term
      - Payment Amount

5. **Payment Systems and Currencies:**
   - **Payment Systems:** A list of supported payment systems, such as Visa, MasterCard, Apple Pay, and others.
      - **System ID**
      - **System Name**
      - Description
   - **Currencies:** A list of supported currencies for accounts and transactions.
      - **Currency ID**
      - Currency Name
      - **Currency Code**


[//]: # (4. **Notifications and Alerts:**)

[//]: # (    - **Notifications:** Informational messages for clients related to their accounts and transactions.)

[//]: # (        - Notification ID)

[//]: # (        - Notification Text)

[//]: # (        - Date and Time)

[//]: # (    - **Alerts:** Notifications about events that require attention, such as insufficient balance or payment due dates.)

[//]: # (        - Alert ID)

[//]: # (        - Alert Text)

[//]: # (        - Date and Time)

[//]: # (1. **Пользователи &#40;Clients and Administrators&#41;:**)

[//]: # (    - **Клиенты &#40;Clients&#41;:** Зарегистрированные пользователи, имеющие доступ к функциональности приложения для управления своими финансами.)

[//]: # (        - Имя &#40;Name&#41;)

[//]: # (        - Фамилия &#40;Surname&#41;)

[//]: # (        - Логин &#40;Username&#41;)

[//]: # (        - Пароль &#40;Password&#41;)

[//]: # (        - Адрес электронной почты &#40;Email&#41;)

[//]: # (        - Номер телефона &#40;Phone Number&#41;)

[//]: # (    - **Администраторы &#40;Administrators&#41;:** Пользователи с правами администратора, которые могут управлять системой и обрабатывать запросы клиентов.)

[//]: # (        - Имя &#40;Name&#41;)

[//]: # (        - Фамилия &#40;Surname&#41;)

[//]: # (        - Логин &#40;Username&#41;)

[//]: # (        - Пароль &#40;Password&#41;)

[//]: # (        - Адрес электронной почты &#40;Email&#41;)

[//]: # (        - Номер телефона &#40;Phone Number&#41;)

[//]: # (        - Роль &#40;Role&#41; - для указания прав доступа.)

[//]: # ()
[//]: # (2. **Банковские счета &#40;Bank Accounts&#41;:**)

[//]: # (    - **Текущие счета &#40;Checking Accounts&#41;:** Банковские счета, на которых клиенты могут хранить средства и совершать транзакции.)

[//]: # (        - Номер счета &#40;Account Number&#41;)

[//]: # (        - Баланс &#40;Balance&#41;)

[//]: # (    - **Сберегательные счета &#40;Savings Accounts&#41;:** Счета, предназначенные для накопления средств с возможностью получения процентов по ним.)

[//]: # (        - Номер счета &#40;Account Number&#41;)

[//]: # (        - Баланс &#40;Balance&#41;)

[//]: # (        - Процентная ставка &#40;Interest Rate&#41;)

[//]: # (    - **Кредитные счета &#40;Credit Accounts&#41;:** Счета, на которых отображаются информация о задолженности клиента по кредитам.)

[//]: # (        - Номер счета &#40;Account Number&#41;)

[//]: # (        - Задолженность &#40;Debt&#41;)

[//]: # (        - Процентная ставка по кредиту &#40;Interest Rate&#41;)

[//]: # ()
[//]: # (3. **Транзакции &#40;Transactions&#41;:**)

[//]: # (    - **Переводы &#40;Transfers&#41;:** Записи о денежных переводах между счетами клиентов.)

[//]: # (        - Идентификатор транзакции &#40;Transaction ID&#41;)

[//]: # (        - Счет отправителя &#40;Sender Account&#41;)

[//]: # (        - Счет получателя &#40;Receiver Account&#41;)

[//]: # (        - Сумма &#40;Amount&#41;)

[//]: # (        - Дата и время &#40;Date and Time&#41;)

[//]: # (    - **История операций &#40;Transaction History&#41;:** Хронология всех финансовых операций, включая детали транзакций.)

[//]: # (        - Идентификатор операции &#40;Operation ID&#41;)

[//]: # (        - Тип операции &#40;Operation Type&#41;)

[//]: # (        - Счет &#40;Account&#41;)

[//]: # (        - Сумма &#40;Amount&#41;)

[//]: # (        - Дата и время &#40;Date and Time&#41;)

[//]: # ()
[//]: # (4. **Уведомления и оповещения &#40;Notifications and Alerts&#41;:**)

[//]: # (    - **Уведомления &#40;Notifications&#41;:** Информационные сообщения для клиентов, связанные с их аккаунтами и операциями.)

[//]: # (        - Идентификатор уведомления &#40;Notification ID&#41;)

[//]: # (        - Текст уведомления &#40;Notification Text&#41;)

[//]: # (        - Дата и время &#40;Date and Time&#41;)

[//]: # (    - **Оповещения &#40;Alerts&#41;:** Уведомления о событиях, требующих внимания, такие как недостаточный баланс или срок платежа.)

[//]: # (        - Идентификатор оповещения &#40;Alert ID&#41;)

[//]: # (        - Текст оповещения &#40;Alert Text&#41;)

[//]: # (        - Дата и время &#40;Date and Time&#41;)

[//]: # ()
[//]: # (5. **Сервисы и продукты банка &#40;Bank Services and Products&#41;:**)

[//]: # (    - **Кредиты &#40;Loans&#41;:** Различные виды кредитов, доступных для клиентов с соответствующими условиями и ставками.)

[//]: # (        - Идентификатор кредита &#40;Loan ID&#41;)

[//]: # (        - Тип кредита &#40;Loan Type&#41;)

[//]: # (        - Сумма кредита &#40;Loan Amount&#41;)

[//]: # (        - Процентная ставка &#40;Interest Rate&#41;)

[//]: # (    - **Депозиты &#40;Deposits&#41;:** Различные виды депозитов с разными условиями и процентными ставками.)

[//]: # (        - Идентификатор депозита &#40;Deposit ID&#41;)

[//]: # (        - Тип депозита &#40;Deposit Type&#41;)

[//]: # (        - Сумма депозита &#40;Deposit Amount&#41;)

[//]: # (        - Процентная ставка &#40;Interest Rate&#41;)

[//]: # (    - **Рассрочки &#40;Installment Plans&#41;:** Варианты рассрочки и платежных планов для приобретения товаров и услуг.)

[//]: # (        - Идентификатор рассрочки &#40;Installment Plan ID&#41;)

[//]: # (        - Описание рассрочки &#40;Description&#41;)

[//]: # (        - Срок рассрочки &#40;Term&#41;)

[//]: # (        - Сумма платежа &#40;Payment Amount&#41;)

[//]: # ()
[//]: # (6. **Платежные системы и валюты &#40;Payment Systems and Currencies&#41;:**)

[//]: # (    - **Платежные системы &#40;Payment Systems&#41;:** Список поддерживаемых платежных систем, таких как Visa, MasterCard, Apple Pay и др.)

[//]: # (        - Название системы &#40;System Name&#41;)

[//]: # (        - Описание &#40;Description&#41;)

[//]: # (    - **Валюты &#40;Currencies&#41;:** Список поддерживаемых валют для счетов и транзакций.)

[//]: # (        - Название валюты &#40;Currency Name&#41;)

[//]: # (        - Код валюты &#40;Currency Code&#41;)

[//]: # (        - Символ валюты &#40;Currency Symbol&#41;)
