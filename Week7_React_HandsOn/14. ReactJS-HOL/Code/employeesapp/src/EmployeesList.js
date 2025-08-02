import EmployeeCard from './EmployeeCard';

function EmployeesList({ employees }) {
  return (
    <div>
      {employees.map((emp, index) => (
        <EmployeeCard key={index} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;