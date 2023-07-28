# JavaSpring

## Формат определения Action (Действие)

### Структура JSON:
- `code` **[*]** - Уникальный код Action (действия). Формат - ASCII без пробелов.
- `name` **[*]** - Название действия
- `group` **[*]** - Значение поля ActionCodeGroupCode из таблицы ADCActionCodeGroupsRef
- `parameters` - параметры действия. Ассоциативный массив, в котором ключ является кодом параметра,\
  значение - объект со следующими ключами:
    - `dataType` **[*]** - [Типы данных](#data-types)
    - `valueType` - [Типы значений](#value-types), по дефолту `SIMPLE`
    - `value` | `method` **[*]** - значение параметра в строковом представлении или\
      динамическое вычисление значения с помощью [SpEL](#spel)
    - `note` - описание параметра

- `userRoles` **[*]** - массив, отвечающий за указание, какие роли могут выполнять эту операцию
    - `ADMINISTRATOR`
    - `SUPERUSER`
    - `OPERATOR`
- `operations` **[*]** - массив уникальных операций, которые будут выполняться во время выполнения action-действия.




### Примеры parameters

 ```json
 "parameters": {
    "BANK_RELATION_TYPE_CODE": {
        "dataType": "STRING",
        "value": "FIDUCIARY",
        "note": "Код связи для поверенного банка"
    },
    "pa$$word": {
        "dataType": "STRING",
        "method": "generatePassword()",
        "note": "Новый сгенерированный пароля пользователя"
    }
 }
 ```

### Пример Action-действия:
```json
{
  "code": "ASSIGN_FIDUCIARY_BANK",
  "name": "Назначение банка поверенного",
  "group": "CONTROL",
  "parameters": {
    "BANK_RELATION_TYPE_CODE": {
      "dataType": "STRING",
      "value": "FIDUCIARY",
      "note": "Код связи для поверенного банка"
    }
  },
  "userRoles": [
    "ADMINISTRATOR"
  ],
  "operations": [
    "FIND_BANK_RELATION_TYPE_ID",
    "CHECK_BANK_HAS_NO_LICENSE",
    "CHECK_BANK_TO_BE_FIDUCIARY",
    "DEACTIVATE_BANKRUPT_FIDUCIARY_BANK_RELATIONS",
    "UPSERT_FIDUCIARY_BANK_RELATION"
  ]
}
```
___
## Формат определения Operation

### Структура JSON:


- `code` **[*]** - Уникальный код Action (действия). Формат - ASCII без пробелов.
- `name` **[*]** - Название операции.
- `objectCode` **[*]** - Код объекта, к которому относится операция.
- `procName` - Название процедуры, которая будет выполняться во время операции.
- `group` **[*]** - Значение поля ActionCodeGroupCode из таблицы ADCActionCodeGroupsRef.
- `configuration` - Конфигурация операции (может быть пустым объектом).
    - `EXACTLY_ONE` - Флаг, указывающий, что операция должна вернуть только один результат.
    - `USE_ACTUAL_VERSION` - Флаг, указывающий, что операция должна использовать актуальную версию данных.
    - `MODE` - Режим выполнения операции. [Виды MODE](#mode-types)
- `search` - Массив параметров для поиска (может быть пустым массивом). _Ниже представлены виды параметров_:
    - `code` - Название уникального параметра в параметрах поиска.
    - `dataType` **[*]** - [Типы данных](#data-types)
    - `contextKey` | `argumentKey` - Ключ, используемый для доступа к значению в некотором контексте или \
      ключ, используемый для доступа к аргументу в методе или функции.
    - `value` | `method` **[*]** - значение параметра в строковом представлении или\
      динамическое вычисление значения с помощью [SpEL](#spel)
    - `note` - Описание параметра. Например, "Банк банкрот".
- `output` - Объект, представляющий выходные параметры операции (может быть пустым объектом). _Ниже представлены виды параметров_:
    - `dataType` - [Типы данных](#data-types)
    - `valueType` - [Типы значений](#value-types)
    - `value` | `method` **[*]** - значение параметра в строковом представлении или\
      динамическое вычисление значения с помощью [SpEL](#spel)
    - `contextKey` | `argumentKey` - Ключ, используемый для доступа к значению в некотором контексте или \
      ключ, используемый для доступа к аргументу в методе или функции.
    - `note` - Описание параметра.
    - `validation`: Объект, содержащий данные для валидации выходного параметра (может быть пустым объектом).
        - `expression`: Выражение для валидации.
        - `message`: Сообщение об ошибке, которое будет отображено в случае, если валидация не пройдет.
- `value`
    - `dataType` - [Типы данных](#тdata-types)
    - `valueType` - [Типы значений](#value-types)
    - `value` | `method` **[*]** - значение параметра в строковом представлении или\
      динамическое вычисление значения с помощью [SpEL](#spel)
    - `contextKey` | `argumentKey` - Ключ, используемый для доступа к значению в некотором контексте или \
      ключ, используемый для доступа к аргументу в методе или функции.
    - `note` - Описание параметра.


### Пример search

```json
"search": [
    {
      "code": "CLIENTID",
      "dataType": "NUMBER",
      "contextKey": "RC_ID"
    }
]
```


### Пример output

```json
"output": {
  "USERROLE_ID": {
      "dataType": "NUMBER",
      "valueType": "LIST",
      "value": "_id",
      "note": "Идентификатор роли пользователя посля выбора"
}
```

### Пример value

```json
"value": {
      "ENDDATE": {
        "dataType": "DATE",
        "method": "getOperDate()"
      },
      "ACTIVE": {
        "dataType": "BOOLEAN",
        "value": false,
        "note": "Признак активности объекта"
      }
    }
```

### Пример Operation:

```json
{
  "code": "FIND_BANK_RELATION_TYPE_ID",
  "name": "Поиск id типа банковской связи по коду",
  "objectCode": "BANKRELATIONTYPE",
  "procName": "SELECT_OBJECT",
  "group": "SERVICE",
  "configuration": {
    "EXACTLY_ONE" : true
  },
  "search": [
    {
      "code": "CODE",
      "dataType": "STRING",
      "contextKey": "BANK_RELATION_TYPE_CODE"
    }
  ],
  "output": {
    "BANK_RELATION_TYPE_ID": {
      "dataType": "NUMBER",
      "value": "_id",
      "note": "Идентификатор типа связи банков"
    }
  }
}
```

### <a name="data-types">Типы данных</a>
- `ID` Идентификатор, приводится к Long
- `BIGINT` Long
- `NUMBER` Число
- `BOOLEAN` true|false, 0|1
- `DATE` Дата, без времени
- `DATETIME` Дата и время
- `TIME` Время
- `STRING` Строка

### <a name="value-types">Типы значений </a>
- `SIMPLE` простое значение
- `LIST` список значений

### <a name="spel">Вычисление выражений SpEL</a>
- [SpEL documentation](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/expressions.html)
- выражения SpEL используются в method и expression во время написания и выполнения операций.
- Определения контекста
    - Переменные контекста: Можно объявлять переменные в контексте, которые будут использоваться в выражениях. Переменные добавляются в контекст перед вычислением выражения.
    - Свойства бинов (bean properties): Можно обращаться к свойствам Spring бинов (Spring beans) и получать их значения в выражениях SpEL.
    - Свойства окружения: Можно получать значения свойств окружения, определенных в конфигурации приложения, и использовать их в выражениях.
    - Методы: Можно вызывать методы на объектах и использовать результаты в выражениях.
- **Примеры**
```json
"RECEIVED_CLAIM_ID": {
    "dataType": "NUMBER",
    "value": "_id",
    "note": "Проверенный идентификатор заявления",
    "validation": {
      "expression": "'RECEIVED' == attrs[STATUSID__CODE]",
      "message": "Найденное заявление в неверном статусе '#{attrs[STATUSID__NAME]}'"
    }
  },
"STARTDATE": {
    "dataType": "DATE",
    "method": "getOperDate()",
    "note": "Дата начала действия роли"
  },
 ```

### <a name="operations-types">Виды операций</a>
- `INSERT_OBJECT` - представляет операцию для добавления новых объектов в систему.
- `UPDATE_OBJECT` - представляет операцию обновления объектов в системе.
- `UPSERT_OBJECT` - представляет операцию, объединяющую в себе обновление и вставку объектов в системе.
- `SELECT_OBJECT` - представляет операцию выборки объектов из хранилища данных.
- `DELETE_OBJECT` - представляет операцию удаления объектов из хранилища данных.
- `LOG_MESSAGE` - представляет операцию журналирования (логирования) сообщений.
- `SEND_EMAIL` - представляет операцию отправки электронной почты.

### <a name="mode-types">Виды MODE</a>
- `SIMPLE`
- `MULTIPLE`























