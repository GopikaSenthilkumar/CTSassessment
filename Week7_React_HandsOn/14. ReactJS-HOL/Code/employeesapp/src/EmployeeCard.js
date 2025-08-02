import ThemeContext from './ThemeContext';
import { useContext } from 'react';
import Styles from './EmployeeCard.module.css';
function EmployeeCard(props) {
    const theme = useContext(ThemeContext);

    return (
        <div className={Styles.Card}>
            <h3>{props.employee.name}</h3>
            <p>{props.employee.email}</p>
            <p>{props.employee.phone}</p>
            <p>
                <a href="#" className={theme === 'dark' ? Styles.DarkButton : Styles.LightButton}>Edit</a>
                <a href="#" className={theme === 'dark' ? Styles.DarkButton : Styles.LightButton}>Delete</a>
            </p>
        </div>
    );
}
export default EmployeeCard;