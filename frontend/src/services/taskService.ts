import { Task, TaskStatus } from '../types/Task';

const API_BASE_URL = 'http://localhost:8080/api/tasks';

export const taskService = {
  getAllTasks: async (): Promise<Task[]> => {
    const response = await fetch(API_BASE_URL);
    if (!response.ok) {
      throw new Error('Failed to fetch tasks');
    }
    return response.json();
  },

  getTasksByStatus: async (status: TaskStatus): Promise<Task[]> => {
    const response = await fetch(`${API_BASE_URL}?status=${status}`);
    if (!response.ok) {
      throw new Error('Failed to fetch tasks by status');
    }
    return response.json();
  },

  getTaskById: async (id: number): Promise<Task> => {
    const response = await fetch(`${API_BASE_URL}/${id}`);
    if (!response.ok) {
      throw new Error('Failed to fetch task');
    }
    return response.json();
  },

  createTask: async (task: Omit<Task, 'id'>): Promise<Task> => {
    const response = await fetch(API_BASE_URL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(task),
    });
    if (!response.ok) {
      throw new Error('Failed to create task');
    }
    return response.json();
  },

  updateTask: async (id: number, task: Omit<Task, 'id'>): Promise<Task> => {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(task),
    });
    if (!response.ok) {
      throw new Error('Failed to update task');
    }
    return response.json();
  },

  deleteTask: async (id: number): Promise<void> => {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
      method: 'DELETE',
    });
    if (!response.ok) {
      throw new Error('Failed to delete task');
    }
  },

  searchTasks: async (title: string): Promise<Task[]> => {
    const response = await fetch(`${API_BASE_URL}/search?title=${encodeURIComponent(title)}`);
    if (!response.ok) {
      throw new Error('Failed to search tasks');
    }
    return response.json();
  },
};