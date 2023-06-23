# tasks
Задачи

1.	Дана базовая модель Профиля, содержащая информацию о компании и самом пользователе. Необходимо реализовать метод получения и сеттинга данных Профиля за установленное время (1 сек), если данные могут быть получены отдельно из разных сервисов (их реализация не важна) также за 1 сек. Задача на параллельное исполнение операций.



    // Модели
    public static class ProfileInfo {
        public UserInfo userInfo;
        public CompanyInfo companyInfo;
    }

    public static class UserInfo {
        public String name;
        public String age;
    }

    public static class CompanyInfo {
        public String id;
        public String companyName;
    }
    
    // методы
    
    //метод должен выполниться за 1 секунду
    public ProfileInfo getProfileInfo(Long id) {
        // TODO необходимо написать реализацию
    }

    private UserInfo getUserInfo(Long id) {
        // вызов внешнего сервиса занимает ~ 1 секунду
    }

    private CompanyInfo getCompanyInfo(Long id) {
        // вызов внешнего сервиса занимает ~ 1 секунду
    }
  





2.	Необходимо написать реализацию метода конвертации данных согласно структуре orgId->groupId->Профили. В каждой организации может быть любое количество групп, в каждой группе любое количество профилей. Профиль однозначно принадлежит конкретной группе (в конкретной организации), соответственно коллизий с пересечениями не предусматриваем.


static public class Profile {
        public Long id;
        public Long orgId;
        public Long groupId;
}
        
public Map<Long, Map<Long, List<Profile>>> groupByOrgIdAndGroupId(List<Profile> data) {
    // TODO необходимо написать реализацию
}

// Пример (входные данные):

[1, 0, 1]
[2, 0, 1]
[3, 0, 2]
[4, 1, 1]
[5, 1, 2]

Result (вывод структуры):
{
    "0": {
        "1" : [{1..}, {2..}],
        "2" : [{3..}],
    }
    "1": {
        "1" : [{4..}],
        "2" : [{5..}]
    }
}
  
