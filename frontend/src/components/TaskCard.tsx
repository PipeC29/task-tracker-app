import React from 'react';
import { Task, TaskStatus } from '../types/Task';

interface TaskCardProps {
  task: Task;
  onEdit: (task: Task) => void;
  onDelete: (id: number) => void;
  getStatusColor: (status: TaskStatus) => string;
}

const TaskCard: React.FC<TaskCardProps> = ({ task, onEdit, onDelete, getStatusColor }) => {
  const handleDelete = () => {
    if (window.confirm('Are you sure you want to delete this task?')) {
      onDelete(task.id!);
    }
  };

  return (
    <div className="bg-white rounded-lg shadow-md p-6 hover:shadow-lg transition-shadow">
      <div className="flex justify-between items-start mb-4">
        <h3 className="text-xl font-semibold text-gray-800 truncate">{task.title}</h3>
        <span className={`px-2 py-1 rounded-full text-xs font-medium ${getStatusColor(task.status)}`}>
          {task.status.replace('_', ' ')}
        </span>
      </div>
      
      <p className="text-gray-600 mb-4 line-clamp-3">{task.description}</p>
      
      <div className="flex gap-2">
        <button
          onClick={() => onEdit(task)}
          className="flex-1 bg-blue-500 hover:bg-blue-600 text-white px-3 py-2 rounded transition-colors"
        >
          Edit
        </button>
        <button
          onClick={handleDelete}
          className="flex-1 bg-red-500 hover:bg-red-600 text-white px-3 py-2 rounded transition-colors"
        >
          Delete
        </button>
      </div>
    </div>
  );
};

export default TaskCard;