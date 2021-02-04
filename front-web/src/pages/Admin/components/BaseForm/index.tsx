import React, { Children } from 'react';
import { useHistory } from 'react-router-dom';
import './styles.scss';

type Props = {
    title: string;
    children: React.ReactNode;
}
const BaseForm = ({title} : Props) => {
const history = useHistory();

    const handleCancel = () => {
        history.push('/admin/products');
    }
    return (
        <div className="admin-base-form card-base ">
            <h1 className="base-form-title">
                {title}
            </h1>
            {Children}
            <div className="base-form-actions">
                <button 
                className="btn btn-outline-danger border-radius-10 mr-3"
                onClick={handleCancel}
                > 
                    cancelar
                </button>
                <button className="btn btn-primary border-radius-10"> 
                    CADASTRAR
                </button>
            </div>
        </div>
    )
}
export default BaseForm;