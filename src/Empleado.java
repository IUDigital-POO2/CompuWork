public class Empleado {
    //El sistema debe permitir la creación, actualización, y eliminación de registros de empleados.
    //
    //Debe incluir funcionalidades para asignar empleados a departamentos específicos y cambiar esta asignación según sea necesario.
    //
    //El sistema debe permitir la gestión de diferentes tipos de empleados, como empleados permanentes y temporales, cada uno con sus propios atributos específicos.

    private String name;
    private String email;
    private String type;
    private String department;
    private String position;
    private String salary;
    private String startDate;
    private String endDate;
    private String contractType;
    private String contractDuration;
    private String contractRenewal;
    private String contractRenewalDate;
    private String contractRenewalDuration;
    private String contractRenewalType;
    private String contractRenewalSalary;
    private String contractRenewalPosition;
    private String contractRenewalDepartment;
    private String contractRenewalStartDate;
    private String contractRenewalEndDate;
    private String contractRenewalContractType;
    private String contractRenewalContractDuration;
    private String contractRenewalContractRenewal;


    public Empleado(String name, String email, String type, String department, String position, String salary, String startDate, String endDate, String contractType, String contractDuration, String contractRenewal, String contractRenewalDate, String contractRenewalDuration, String contractRenewalType, String contractRenewalSalary, String contractRenewalPosition, String contractRenewalDepartment, String contractRenewalStartDate, String contractRenewalEndDate, String contractRenewalContractType, String contractRenewalContractDuration, String contractRenewalContractRenewal) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractType = contractType;
        this.contractDuration = contractDuration;
        this.contractRenewal = contractRenewal;
        this.contractRenewalDate = contractRenewalDate;
        this.contractRenewalDuration = contractRenewalDuration;
        this.contractRenewalType = contractRenewalType;
        this.contractRenewalSalary = contractRenewalSalary;
        this.contractRenewalPosition = contractRenewalPosition;
        this.contractRenewalDepartment = contractRenewalDepartment;
        this.contractRenewalStartDate = contractRenewalStartDate;
        this.contractRenewalEndDate = contractRenewalEndDate;
        this.contractRenewalContractType = contractRenewalContractType;
        this.contractRenewalContractDuration = contractRenewalContractDuration;
        this.contractRenewalContractRenewal = contractRenewalContractRenewal;
        //requiero que me instancies los atributos

    }
}
