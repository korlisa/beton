package ru.sfedu.vetClinicH.provider;

import ru.sfedu.vetClinicH.constants.Result;


public interface IDataProviderHibernate {

    // SAVE

    /**
     *
     * @param name
     * @param breed
     * @param gender
     * @param age
     * @param weight
     * @param vac
     * @param wingspan
     * @param type
     * @return
     */
    public Result saveBirds(String name, String breed, String gender, int age, int weight, boolean vac, int wingspan, String type);

    /**
     *
     * @param name
     * @param breed
     * @param gender
     * @param age
     * @param weight
     * @param vac
     * @param woolLength
     * @param type
     * @return
     */
    public Result saveMammals(String name, String breed, String gender, int age, int weight, boolean vac, int woolLength, String type);


    /**
     *
     * @param name
     * @param breed
     * @param gender
     * @param age
     * @param weight
     * @param vac
     * @param toxic
     * @param type
     * @return
     */
    public Result saveReptiles(String name, String breed, String gender, int age, int weight, boolean vac, boolean toxic, String type);


    // UPDATE

    /**
     *
     * @param id
     * @param name
     * @param breed
     * @param gender
     * @param age
     * @param weight
     * @param vac
     * @param wingspan
     * @param type
     * @return
     */
    public Result updateBirds (long id, String name, String breed, String gender, int age, int weight, boolean vac, int wingspan, String type);

    /**
     *
     * @param id
     * @param name
     * @param breed
     * @param gender
     * @param age
     * @param weight
     * @param vac
     * @param woolLength
     * @param type
     * @return
     */
    public Result updateMammals (long id, String name, String breed, String gender, int age, int weight, boolean vac, int woolLength, String type);

    /**
     *
     * @param id
     * @param name
     * @param breed
     * @param gender
     * @param age
     * @param weight
     * @param vac
     * @param toxic
     * @param type
     * @return
     */
    public Result updateReptiles (long id, String name, String breed, String gender, int age, int weight, boolean vac, boolean toxic, String type);


    // GET

    /**
     *
     * @param id
     * @return
     */
    public Object getBirds(long id);

    /**
     *
     * @param id
     * @return
     */
    public Object getMammals(long id);

    /**
     *
     * @param id
     * @return
     */
    public Object getReptiles(long id);


    // DELETE


    /**
     *
      * @param id
     * @return
     */
    public Result delBirds (long id);

    /**
     *
     * @param id
     * @return
     */
    public  Result delMammals (long id);

    /**
     *
     * @param id
     * @return
     */
    public  Result delReptiles (long id);


}
